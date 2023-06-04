#!/usr/bin/env python
# -*- coding: utf-8 -*-

import os.path
import glob
import os
import re
import sys
import string
import shutil
import stat
import time
from time import gmtime, strftime
from random import Random

test_names = []
current = []
test_sections = []
sample_types = []
descriptions = []
print_names = []
old_sort = []
uom = []
hand_edit = ['PaCO2','HCO3']
current_tests_file = open('testNameCurrent.txt','r')
name_file = open('testNameDesired.txt','r')
test_section_file = open("testSections.txt",'r')
sample_type_file = open("sampleType.txt")
uom_file = open("newUOM.txt", 'r')
print_name_file = open("printName.txt")
results = open("testResults.txt", 'w')

def convert_to_existing_name( name ):
    if name == 'Hematologie':
        return 'Hematology'
    elif name == 'Biochimie':
        return 'Biochemistry'
    elif name == 'Mycobacteriologie':
        return 'Mycrobacteriology'
    elif name == 'Parasitologie':
        return 'Parasitology'
    elif name == 'Immuno-virologie':
        return 'Immunology'
    elif name == 'Immuno-Virologie':
        return 'Immunology'
    elif name == 'CDV':
        return 'VCT'

    return name

def esc_char(name):
    if "'" in name:
        return "$$" + name + "$$"
    else:
        return "'" + name + "'"


def use_uom( uom ):
    return  len(uom) > 0 and uom != 'n/a'

for line in name_file:
    test_names.append(line.strip())

for line in print_name_file:
    print_names.append(line.strip())
print_name_file.close()

for line in current_tests_file:
    current.append( line.strip())
current_tests_file.close()

for line in test_section_file:
    test_sections.append(line.strip())

for line in sample_type_file:
    sample_types.append(line.strip())
    
name_file.close()
test_section_file.close()

for line in uom_file:
    uom.append(line.strip())
uom_file.close()

sql_head = "INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )\n\t"
results.write("The following should go in massiveTests.sql Note\n")

sort_count = 10
for row in range(0, len(test_names)):
    if len(test_names[row]) > 1:
        description = esc_char(test_names[row] + "(" + sample_types[row] + ")")
        if description not in descriptions:
            descriptions.append(description)
            if len(current[row]) < 2:  #means its new
                    results.write( sql_head)
                    results.write("VALUES ( nextval( 'test_seq' ) ," )
                    if use_uom(uom[row]):
                        results.write(" ( select id from clinlims.unit_of_measure where name='" + uom[row] + "') , ")
                    else:
                        results.write(" null , ")
                    results.write( description + " , " + esc_char(print_names[row]) + " , 'Y' , 'N' , now() , ")
                    results.write("(select id from clinlims.test_section where name = '" + convert_to_existing_name(test_sections[row]) + "' ) ,")
                    results.write( esc_char(test_names[row][:20]) + " ," + str(sort_count) + " , " + esc_char(test_names[row]) + " );\n")
                    sort_count += 10
            else:
                if len(test_names[row]) > 1:
                        description = esc_char(test_names[row] + "(" + sample_types[row] + ")")
                        old_sort.append("update clinlims.test set sort_order=" + str(sort_count) + " , " )
                        old_sort.append( " reporting_description = " + esc_char(print_names[row]) + " ")
                        old_sort.append( " where description = " + description + ";\n")

                sort_count += 10

results.write("\n\nThe following should go in testOrder.sql\n\n")

for line in old_sort:
    results.write(line)

results.close()

print "Done look for results in testResults.txt"