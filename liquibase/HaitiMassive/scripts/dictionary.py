
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

def get_comma_split_names( name ):
    split_name_list = [name]

    if ',' in name:
        split_name_list = name.split(",")
    elif ';' in name:
        split_name_list = name.split(";")

    for i in range(0, len(split_name_list)):
        split_name_list[i] = split_name_list[i].strip()

    return split_name_list


old = []

old_file = open("currentDictNames.txt")
new_file = open("selectList.txt")
result = open("dictionaryResult.sql",'w')

for line in old_file:
    old.append(line.strip())
old_file.close()

for line in new_file:
    if len(line) > 1:
        values = get_comma_split_names(line)

        for value in values:
            if value.strip() not in old:
                old.append(value.strip())
                result.write("INSERT INTO clinlims.dictionary ( id, is_active, dict_entry, lastupdated, dictionary_category_id ) \n\t")
                result.write("VALUES ( nextval( 'dictionary_seq' ) , 'Y' , '" + value.strip() + "' , now(), ( select id from clinlims.dictionary_category where description = 'Haiti Lab' ));\n")

result.close()

print "Done check dictionaryResult.sql for values"


