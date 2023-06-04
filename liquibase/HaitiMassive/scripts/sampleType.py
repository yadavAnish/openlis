#!/usr/bin/env python
# -*- coding: utf-8 -*-

import os.path
import glob
import os
import sys
import string
import shutil
import stat
import time
from time import gmtime, strftime
from random import Random

existing_types = [ "Sang",
"Plasma",
"Serum",
"Urine",
"Selles",
"Crachat",
"Secretion Urethrale",
"Secretion Vaginale",
"Pus",
"LCR",
"Liquide Ascite",
"Liquide Synovial",
"Liquide Amniotique",
"Liquide Pleural",
"Serum/Urine concentre du matin",
"Culot Urinaire",
"Secretions genito-urinaire",
"Aspiration nasopharyng�e",
"Ecouvillonage nasal",
"Ecouvillonage nosapharyng�",
"S�cr�tion de la gorge",
"DBS",
"Pr�l�vement rhinopharyng�"
]
sample_types = []

sample_type_file = open("sampleType.txt")
results = open("sampleTypeOutput.txt", 'w')


def write_massive_type_of_sample():
    results.write("\nPaste following in MassiveSampleType.sql\n\n")

    sql_insert = "INSERT INTO type_of_sample( id, description, domain, lastupdated, local_abbrev, display_key, is_active )\n\tVALUES ("
    for line in sample_types:
        if line not in existing_types and len(line) > 1:
            results.write(sql_insert)
            results.write( " nextval( 'type_of_sample_seq' ) , '" + line + "','H', now() , '" + line[:10] + "', 'sample.type." + line.split()[0] + "', 'Y');\n" );

def write_sample_type_order():
    results.write("\nPaste following in MassiveUpdate.xml under Remove the unused sample types and add the new sample types\n\n")
    order = 1
    for line in sample_types:
        results.write("update clinlims.type_of_sample set sort_order=" + str(order) + " where description ILIKE '" + line + "';\n")
        order = order + 1

def write_inactive_list():
    results.write('\nPaste following in MassiveUpdate in the set inactive list\n\n')
    for line in existing_types:
        if line not in sample_types:
            results.write(line + ', ')



for line in sample_type_file:
    if len(line) > 1:
        if line.strip() not in sample_types:
            sample_types.append(line.strip())


write_massive_type_of_sample()
write_sample_type_order()
write_inactive_list()

print "Done check file sampleTypeOutput.txt"
results.close();