INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Test Rapide VIH(Sang)' , 'VIH test rapide' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Test Rapide VIH' ,10 , 'Test Rapide VIH' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Test Rapide VIH(Plasma)' , 'VIH test rapide' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Test Rapide VIH' ,20 , 'Test Rapide VIH' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Test Rapide VIH(DBS)' , 'VIH test rapide' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Test Rapide VIH' ,30 , 'Test Rapide VIH' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'VIH Elisa(Sang)' , 'Elisa VIH' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'VIH Elisa' ,40 , 'VIH Elisa' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Test Rapide VIH(Serum)' , 'VIH test rapide' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Test Rapide VIH' ,50 , 'Test Rapide VIH' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'VIH Elisa(Serum)' , 'Elisa VIH' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'VIH Elisa' ,60 , 'VIH Elisa' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'VIH Elisa(Plasma)' , 'Elisa VIH' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'VIH Elisa' ,70 , 'VIH Elisa' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'VIH Elisa(DBS)' , 'Elisa VIH' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'VIH Elisa' ,80 , 'VIH Elisa' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'VIH Western Blot(Sang)' , 'VIH Western blot' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'VIH Western Blot' ,90 , 'VIH Western Blot' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'VIH Western Blot(Serum)' , 'VIHWestern blot' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'VIH Western Blot' ,100 , 'VIH Western Blot' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'VIH Western Blot(Plasma)' , 'VIHWestern blot' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'VIH Western Blot' ,110 , 'VIH Western Blot' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'VIH Western Blot(DBS)' , 'VIHWestern blot' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'VIH Western Blot' ,120 , 'VIH Western Blot' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Rougeole(Serum)' , 'Rougeole' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Rougeole' ,130 , 'Rougeole' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Rougeole(Plasma)' , 'Rougeole' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Rougeole' ,140 , 'Rougeole' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Dengue(Serum)' , 'Dengue' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Dengue' ,150 , 'Dengue' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Dengue(Plasma)' , 'Dengue' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Dengue' ,160 , 'Dengue' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Rubeole(Serum)' , 'Rubeole' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Rubeole' ,170 , 'Rubeole' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Rubeole(Plasma)' , 'Rubeole' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Rubeole' ,180 , 'Rubeole' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Dengue NS1Ag(Serum)' , 'Dengue NS1Ag' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Dengue NS1Ag' ,190 , 'Dengue NS1Ag' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Dengue NS1Ag(Plasma)' , 'Dengue NS1Ag' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Dengue NS1Ag' ,200 , 'Dengue NS1Ag' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Hepatite A IgM(Serum)' , 'Hepatite A IgM Aby' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Hepatite A IgM' ,210 , 'Hepatite A IgM' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Hepatite A IgM(Plasma)' , 'Hepatite A IgM Aby' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Hepatite A IgM' ,220 , 'Hepatite A IgM' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Hepatite B Ag(Serum)' , 'Hepatite B Ag' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Hepatite B Ag' ,230 , 'Hepatite B Ag' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Hepatite B Ag(Plasma)' , 'Hepatite B Ag' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Hepatite B Ag' ,240 , 'Hepatite B Ag' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Hepatite C IgM(Serum)' , 'Hepatite C IgM Aby' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Hepatite C IgM' ,250 , 'Hepatite C IgM' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Hepatite C IgM(Plasma)' , 'Hepatite C IgM Aby' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Hepatite C IgM' ,260 , 'Hepatite C IgM' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Hepatite E IgM(Serum)' , 'Hepatite E IgM Aby' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Hepatite E IgM' ,270 , 'Hepatite E IgM' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Hepatite E IgM(Plasma)' , 'Hepatite E IgM Aby' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Hepatite E IgM' ,280 , 'Hepatite E IgM' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Influenza A/Immunofluoresence(Ecouvillon Nasal)' , 'Influenza A' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Influenza A/Immunofl' ,290 , 'Influenza A/Immunofluoresence' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Influenza A/Immunofluoresence(Ecouvillon Pharynge)' , 'Influenza A' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Influenza A/Immunofl' ,300 , 'Influenza A/Immunofluoresence' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Influenza A/Immunofluoresence(Ecouvillon Naso-Pharynge)' , 'Influenza A' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Influenza A/Immunofl' ,310 , 'Influenza A/Immunofluoresence' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Influenza B/Immunofluoresence(Ecouvillon Nasal)' , 'Influenza B' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Influenza B/Immunofl' ,320 , 'Influenza B/Immunofluoresence' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Influenza B/Immunofluoresence(Ecouvillon Pharynge)' , 'Influenza B' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Influenza B/Immunofl' ,330 , 'Influenza B/Immunofluoresence' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Influenza B/Immunofluoresence(Ecouvillon Naso-Pharynge)' , 'Influenza B' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Influenza B/Immunofl' ,340 , 'Influenza B/Immunofluoresence' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Para Influenza 1/Immunofluoresence(Ecouvillon Nasal)' , 'Para Influenza 1' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Para Influenza 1/Imm' ,350 , 'Para Influenza 1/Immunofluoresence' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Para Influenza 1/Immunofluoresence(Ecouvillon Pharynge)' , 'Para Influenza 1' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Para Influenza 1/Imm' ,360 , 'Para Influenza 1/Immunofluoresence' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Para Influenza 1/Immunofluoresence(Ecouvillon Naso-Pharynge)' , 'Para Influenza 1' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Para Influenza 1/Imm' ,370 , 'Para Influenza 1/Immunofluoresence' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Para Influenza 2/Immunofluoresence(Ecouvillon Nasal)' , 'Para Influenza 2' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Para Influenza 2/Imm' ,380 , 'Para Influenza 2/Immunofluoresence' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Para Influenza 2/Immunofluoresence(Ecouvillon Pharynge)' , 'Para Influenza 2' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Para Influenza 2/Imm' ,390 , 'Para Influenza 2/Immunofluoresence' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Para Influenza 2/Immunofluoresence(Ecouvillon Naso-Pharynge)' , 'Para Influenza 2' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Para Influenza 2/Imm' ,400 , 'Para Influenza 2/Immunofluoresence' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Para Influenza 3/Immunofluoresence(Ecouvillon Nasal)' , 'Para Influenza 3' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Para Influenza 3/Imm' ,410 , 'Para Influenza 3/Immunofluoresence' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Para Influenza 3/Immunofluoresence(Ecouvillon Pharynge)' , 'Para Influenza 3' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Para Influenza 3/Imm' ,420 , 'Para Influenza 3/Immunofluoresence' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Para Influenza 3/Immunofluoresence(Ecouvillon Naso-Pharynge)' , 'Para Influenza 3' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Para Influenza 3/Imm' ,430 , 'Para Influenza 3/Immunofluoresence' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Virus Respiratoire Synctial(Ecouvillon Nasal)' , 'Virus Respiratoire  Synccytial' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Virus Respiratoire S' ,440 , 'Virus Respiratoire Synctial' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Virus Respiratoire Synctial(Ecouvillon Pharynge)' , 'Virus Respiratoire  Synccytial' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Virus Respiratoire S' ,450 , 'Virus Respiratoire Synctial' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Virus Respiratoire Synctial(Ecouvillon Naso-Pharynge)' , 'Virus Respiratoire  Synccytial' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Virus Respiratoire S' ,460 , 'Virus Respiratoire Synctial' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Adenivirus/Immunofluoresence(Ecouvillon Nasal)' , 'Adenovirus' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Adenivirus/Immunoflu' ,470 , 'Adenivirus/Immunofluoresence' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Adenivirus/Immunofluoresence(Ecouvillon Pharynge)' , 'Adenovirus' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Adenivirus/Immunoflu' ,480 , 'Adenivirus/Immunofluoresence' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Adenivirus/Immunofluoresence(Ecouvillon Naso-Pharynge)' , 'Adenovirus' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Adenivirus/Immunoflu' ,490 , 'Adenivirus/Immunofluoresence' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Rotavirus Elisa(Selles)' , 'Rotavirus' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Rotavirus Elisa' ,500 , 'Rotavirus Elisa' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'SyphilisTest Rapid(Serum)' , 'Syphilis Test Rapid' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'SyphilisTest Rapid' ,510 , 'SyphilisTest Rapid' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Polio Selles 1(Selles 1)' , 'Polio Selles 1' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Polio Selles 1' ,520 , 'Polio Selles 1' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Polio Selles 2(Selles 2)' , 'Polio Selles 2' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Polio Selles 2' ,530 , 'Polio Selles 2' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Syphilis RPR(Serum)' , 'Syphilis RPR' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Syphilis RPR' ,540 , 'Syphilis RPR' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Syphilis TPHA(Serum)' , 'Syphilis TPHA' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Syphilis TPHA' ,550 , 'Syphilis TPHA' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'VIH-1 PCR Qualitatif(DBS)' , 'VIH-1 PCR Qualitatif' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Biologie Moleculaire' ) ,'VIH-1 PCR Qualitatif' ,560 , 'VIH-1 PCR Qualitatif' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'VIH-1 PCR Qualitatif(Sang Total)' , 'VIH-1 PCR Qualitatif' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Biologie Moleculaire' ) ,'VIH-1 PCR Qualitatif' ,570 , 'VIH-1 PCR Qualitatif' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , ( select id from clinlims.unit_of_measure where name='Copies/ml (log)') , 'VIH-1 Charge Virale(Plasma)' , 'VIH-1 Charge Virale' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Biologie Moleculaire' ) ,'VIH-1 Charge Virale' ,580 , 'VIH-1 Charge Virale' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , ( select id from clinlims.unit_of_measure where name='Copies/ml (log)') , 'VIH-1 Charge Virale(DBS)' , 'VIH-1 Charge Virale' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Biologie Moleculaire' ) ,'VIH-1 Charge Virale' ,590 , 'VIH-1 Charge Virale' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Recherche de Virus Respiratoire Influenza(Ecouvillon Naso-Pharynge)' , 'PCR Influenza' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Biologie Moleculaire' ) ,'Recherche de Virus R' ,600 , 'Recherche de Virus Respiratoire Influenza' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Germes Enterogastriques pathogènes(Selles)' , 'Gastroenteric Pathogens' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Biologie Moleculaire' ) ,'Germes Enterogastriq' ,610 , 'Germes Enterogastriques pathogènes' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Virus Respiratoire(Ecouvillon Naso-Pharynge)' , 'Virus respiratoire' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Biologie Moleculaire' ) ,'Virus Respiratoire' ,620 , 'Virus Respiratoire' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Micobacterium tuberculosis Drug Resistant(Culture)' , 'Micobacterium tuberculosis Drug Resistant' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Biologie Moleculaire' ) ,'Micobacterium tuberc' ,630 , 'Micobacterium tuberculosis Drug Resistant' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Micobacterium tuberculosis Drug Resistant(Sputum)' , 'Micobacterium tuberculosis Drug Resistant' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Biologie Moleculaire' ) ,'Micobacterium tuberc' ,640 , 'Micobacterium tuberculosis Drug Resistant' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , ( select id from clinlims.unit_of_measure where name='µl') , 'CD4  Compte Abs(Sang Total)' , 'CD4' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Hematology' ) ,'CD4  Compte Abs' ,650 , 'CD4  Compte Abs' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , ( select id from clinlims.unit_of_measure where name='%') , 'CD4 Compte en %(Sang Total)' , 'CD4%' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Hematology' ) ,'CD4 Compte en %' ,660 , 'CD4 Compte en %' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , ( select id from clinlims.unit_of_measure where name='mille/mm3') , 'Compte des Globules Blancs(Sang)' , 'Compte des Globules Blancs' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Hematology' ) ,'Compte des Globules ' ,670 , 'Compte des Globules Blancs' , '26464-8');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , ( select id from clinlims.unit_of_measure where name='million/mm3') , 'Compte des Globules Rouges(Sang)' , 'Compte des Globules Rouges' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Hematology' ) ,'Compte des Globules ' ,680 , 'Compte des Globules Rouges' , '26453-1');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , ( select id from clinlims.unit_of_measure where name='g/dl') , 'Hemoglobine(Sang)' , 'Hemoglobine' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Hematology' ) ,'Hemoglobine' ,690 , 'Hemoglobine' , '718-7');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , ( select id from clinlims.unit_of_measure where name='%') , 'Hematocrite(Sang)' , 'Hematocrite' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Hematology' ) ,'Hematocrite' ,700 , 'Hematocrite' , '20570-8');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , ( select id from clinlims.unit_of_measure where name='fl') , 'VGM(Sang)' , 'VGM' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Hematology' ) ,'VGM' ,710 , 'VGM' , '30428-7');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , ( select id from clinlims.unit_of_measure where name='pg') , 'TCMH(Sang)' , 'TCMH' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Hematology' ) ,'TCMH' ,720 , 'TCMH' , '28539-5');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , ( select id from clinlims.unit_of_measure where name='%') , 'CCMH(Sang)' , 'CCMH' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Hematology' ) ,'CCMH' ,730 , 'CCMH' , '28540-3');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , ( select id from clinlims.unit_of_measure where name='mille/mm3') , 'Plaquettes(Sang)' , 'Plaquettes' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Hematology' ) ,'Plaquettes' ,740 , 'Plaquettes' , '26515-7');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , ( select id from clinlims.unit_of_measure where name='%') , 'Neutrophiles(Sang)' , 'Neutrophiles' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Hematology' ) ,'Neutrophiles' ,750 , 'Neutrophiles' , '26511-6');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , ( select id from clinlims.unit_of_measure where name='%') , 'Lymphocytes(Sang)' , 'Lymphocytes' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Hematology' ) ,'Lymphocytes' ,760 , 'Lymphocytes' , '26478-8');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , ( select id from clinlims.unit_of_measure where name='%') , 'Mixtes(Sang)' , 'Mixtes' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Hematology' ) ,'Mixtes' ,770 , 'Mixtes' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'LCR Coloration de Gram  (LCR)' , 'Gram' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'LCR Coloration de Gr' ,780 , 'LCR Coloration de Gram  ' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Selles Coloration de Gram(Selles)' , 'Gram' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Selles Coloration de' ,790 , 'Selles Coloration de Gram' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Coloration de Gram Ecouvillon Pharynge(Ecouvillon Pharynge)' , 'Gram' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Coloration de Gram E' ,800 , 'Coloration de Gram Ecouvillon Pharynge' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Coloration de Gram Ecouvillon Naso-Pharynge(Ecouvillon Naso-Pharynge)' , 'Gram' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Coloration de Gram E' ,810 , 'Coloration de Gram Ecouvillon Naso-Pharynge' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Coloration de Gram Sang(Sang)' , 'Gram' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Coloration de Gram S' ,820 , 'Coloration de Gram Sang' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Immuno Dot Leptospira IgM (Serum)' , 'Leptospira IgM ' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Immuno Dot Leptospir' ,830 , 'Immuno Dot Leptospira IgM ' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Leptospirose IgM(Plasma)' , 'Leptospira IgM' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Leptospirose IgM' ,840 , 'Leptospirose IgM' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Leptospirose IgM(Sang)' , 'Leptospira IgM' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Leptospirose IgM' ,850 , 'Leptospirose IgM' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Leptospirose IgM(Sang capillaire)' , 'Leptospira IgM' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Leptospirose IgM' ,860 , 'Leptospirose IgM' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Hemoculture IgM(Sang)' , 'Hemoculture' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Hemoculture IgM' ,870 , 'Hemoculture IgM' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Test RapideSalmonelle typhi IgM 09(Serum)' , 'Test Rapide Salmonelle typhi IgM 09' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Test RapideSalmonell' ,880 , 'Test RapideSalmonelle typhi IgM 09' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Test Rapide Salmonelle typhi  IgM 09(Selles)' , 'Test Rapide Salmonelle typhi IgM 09' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Test Rapide Salmonel' ,890 , 'Test Rapide Salmonelle typhi  IgM 09' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'LCR : Culture(LCR)' , 'LCR Culture' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'LCR : Culture' ,900 , 'LCR : Culture' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'LCR Test Rapide(LCR)' , 'LCR test Rapide' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'LCR Test Rapide' ,910 , 'LCR Test Rapide' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Recherche de Salmonelle(Selles)' , 'Recherche de Salmonelle' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Recherche de Salmone' ,920 , 'Recherche de Salmonelle' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Recherche de Shigelle(Selles)' , 'Recherche de Shigelle' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Recherche de Shigell' ,930 , 'Recherche de Shigelle' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Recherche de V.cholerae(Selles)' , 'Recherche de V.cholerae' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Recherche de V.chole' ,940 , 'Recherche de V.cholerae' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Recherche de C. diphteriae(Ecouvillon Pharynge)' , 'Recherche de C. diphteriae' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Recherche de C. diph' ,950 , 'Recherche de C. diphteriae' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Recherche de B. pertussis(Ecouvillon Naso-Pharynge)' , 'Recherche de B. pertussis' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Recherche de B. pert' ,960 , 'Recherche de B. pertussis' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Acide nalidixique 30 μg(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Acide nalidixique 30' ,970 , 'Acide nalidixique 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Acide nalidixique 30 μg(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Acide nalidixique 30' ,980 , 'Acide nalidixique 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Acide nalidixique 30 μg(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Acide nalidixique 30' ,990 , 'Acide nalidixique 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Acide nalidixique 30 μg(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Acide nalidixique 30' ,1000 , 'Acide nalidixique 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Acide nalidixique 30 μg(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Acide nalidixique 30' ,1010 , 'Acide nalidixique 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Acide nalidixique 30 μg(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Acide nalidixique 30' ,1020 , 'Acide nalidixique 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Acide fusidique 10 μg(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Acide fusidique 10' ,1030 , 'Acide fusidique 10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Acide fusidique 10 μg(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Acide fusidique 10' ,1040 , 'Acide fusidique 10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Acide fusidique 10 μg(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Acide fusidique 10' ,1050 , 'Acide fusidique 10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Acide fusidique 10 μg(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Acide fusidique 10' ,1060 , 'Acide fusidique 10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Acide fusidique 10 μg(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Acide fusidique 10' ,1070 , 'Acide fusidique 10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Acide fusidique 10 μg(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Acide fusidique 10' ,1080 , 'Acide fusidique 10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Amikacine 30 μg(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Amikacine 30 μg' ,1090 , 'Amikacine 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Amikacine 30 μg(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Amikacine 30 μg' ,1100 , 'Amikacine 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Amikacine 30 μg(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Amikacine 30 μg' ,1110 , 'Amikacine 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Amikacine 30 μg(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Amikacine 30 μg' ,1120 , 'Amikacine 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Amikacine 30 μg(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Amikacine 30 μg' ,1130 , 'Amikacine 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Amikacine 30 μg(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Amikacine 30 μg' ,1140 , 'Amikacine 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ampicilline 10 μg(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ampicilline 10 μg' ,1150 , 'Ampicilline 10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ampicilline 10 μg(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ampicilline 10 μg' ,1160 , 'Ampicilline 10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ampicilline 10 μg(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ampicilline 10 μg' ,1170 , 'Ampicilline 10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ampicilline 10 μg(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ampicilline 10 μg' ,1180 , 'Ampicilline 10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ampicilline 10 μg(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ampicilline 10 μg' ,1190 , 'Ampicilline 10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ampicilline 10 μg(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ampicilline 10 μg' ,1200 , 'Ampicilline 10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ampicilline/Sulbactam 10/10 μg(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ampicilline/Sulbacta' ,1210 , 'Ampicilline/Sulbactam 10/10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ampicilline/Sulbactam 10/10 μg(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ampicilline/Sulbacta' ,1220 , 'Ampicilline/Sulbactam 10/10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ampicilline/Sulbactam 10/10 μg(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ampicilline/Sulbacta' ,1230 , 'Ampicilline/Sulbactam 10/10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ampicilline/Sulbactam 10/10 μg(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ampicilline/Sulbacta' ,1240 , 'Ampicilline/Sulbactam 10/10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ampicilline/Sulbactam 10/10 μg(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ampicilline/Sulbacta' ,1250 , 'Ampicilline/Sulbactam 10/10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ampicilline/Sulbactam 10/10 μg(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ampicilline/Sulbacta' ,1260 , 'Ampicilline/Sulbactam 10/10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Amoxicilline/Acide clavulanique 20/10 μg(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Amoxicilline/Acide c' ,1270 , 'Amoxicilline/Acide clavulanique 20/10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Amoxicilline/Acide clavulanique 20/10 μg(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Amoxicilline/Acide c' ,1280 , 'Amoxicilline/Acide clavulanique 20/10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Amoxicilline/Acide clavulanique 20/10 μg(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Amoxicilline/Acide c' ,1290 , 'Amoxicilline/Acide clavulanique 20/10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Amoxicilline/Acide clavulanique 20/10 μg(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Amoxicilline/Acide c' ,1300 , 'Amoxicilline/Acide clavulanique 20/10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Amoxicilline/Acide clavulanique 20/10 μg(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Amoxicilline/Acide c' ,1310 , 'Amoxicilline/Acide clavulanique 20/10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Amoxicilline/Acide clavulanique 20/10 μg(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Amoxicilline/Acide c' ,1320 , 'Amoxicilline/Acide clavulanique 20/10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Azithromicine 15 μg(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Azithromicine 15 μg' ,1330 , 'Azithromicine 15 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Azithromicine 15 μg(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Azithromicine 15 μg' ,1340 , 'Azithromicine 15 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Azithromicine 15 μg(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Azithromicine 15 μg' ,1350 , 'Azithromicine 15 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Azithromicine 15 μg(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Azithromicine 15 μg' ,1360 , 'Azithromicine 15 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Azithromicine 15 μg(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Azithromicine 15 μg' ,1370 , 'Azithromicine 15 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Azithromicine 15 μg(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Azithromicine 15 μg' ,1380 , 'Azithromicine 15 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Aztreinam 30 μg(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Aztreinam 30 μg' ,1390 , 'Aztreinam 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Aztreinam 30 μg(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Aztreinam 30 μg' ,1400 , 'Aztreinam 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Aztreinam 30 μg(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Aztreinam 30 μg' ,1410 , 'Aztreinam 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Aztreinam 30 μg(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Aztreinam 30 μg' ,1420 , 'Aztreinam 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Aztreinam 30 μg(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Aztreinam 30 μg' ,1430 , 'Aztreinam 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Aztreinam 30 μg(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Aztreinam 30 μg' ,1440 , 'Aztreinam 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Cefalotine 30 μg(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Cefalotine 30 μg' ,1450 , 'Cefalotine 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Cefalotine 30 μg(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Cefalotine 30 μg' ,1460 , 'Cefalotine 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Cefalotine 30 μg(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Cefalotine 30 μg' ,1470 , 'Cefalotine 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Cefalotine 30 μg(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Cefalotine 30 μg' ,1480 , 'Cefalotine 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Cefalotine 30 μg(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Cefalotine 30 μg' ,1490 , 'Cefalotine 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Cefalotine 30 μg(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Cefalotine 30 μg' ,1500 , 'Cefalotine 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Cefotaxime 30 μg(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Cefotaxime 30 μg' ,1510 , 'Cefotaxime 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Cefotaxime 30 μg(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Cefotaxime 30 μg' ,1520 , 'Cefotaxime 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Cefotaxime 30 μg(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Cefotaxime 30 μg' ,1530 , 'Cefotaxime 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Cefotaxime 30 μg(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Cefotaxime 30 μg' ,1540 , 'Cefotaxime 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Cefotaxime 30 μg(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Cefotaxime 30 μg' ,1550 , 'Cefotaxime 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Cefotaxime 30 μg(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Cefotaxime 30 μg' ,1560 , 'Cefotaxime 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ceftazidime 30 μg(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ceftazidime 30 μg' ,1570 , 'Ceftazidime 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ceftazidime 30 μg(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ceftazidime 30 μg' ,1580 , 'Ceftazidime 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ceftazidime 30 μg(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ceftazidime 30 μg' ,1590 , 'Ceftazidime 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ceftazidime 30 μg(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ceftazidime 30 μg' ,1600 , 'Ceftazidime 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ceftazidime 30 μg(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ceftazidime 30 μg' ,1610 , 'Ceftazidime 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ceftazidime 30 μg(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ceftazidime 30 μg' ,1620 , 'Ceftazidime 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ceftriaxone 30 μg(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ceftriaxone 30 μg' ,1630 , 'Ceftriaxone 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ceftriaxone 30 μg(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ceftriaxone 30 μg' ,1640 , 'Ceftriaxone 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ceftriaxone 30 μg(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ceftriaxone 30 μg' ,1650 , 'Ceftriaxone 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ceftriaxone 30 μg(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ceftriaxone 30 μg' ,1660 , 'Ceftriaxone 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ceftriaxone 30 μg(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ceftriaxone 30 μg' ,1670 , 'Ceftriaxone 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ceftriaxone 30 μg(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ceftriaxone 30 μg' ,1680 , 'Ceftriaxone 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Cefixime10 μg(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Cefixime10 μg' ,1690 , 'Cefixime10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Cefixime10 μg(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Cefixime10 μg' ,1700 , 'Cefixime10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Cefixime10 μg(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Cefixime10 μg' ,1710 , 'Cefixime10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Cefixime10 μg(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Cefixime10 μg' ,1720 , 'Cefixime10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Cefixime10 μg(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Cefixime10 μg' ,1730 , 'Cefixime10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Cefixime10 μg(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Cefixime10 μg' ,1740 , 'Cefixime10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ceftizoxime 30 μg(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ceftizoxime 30 μg' ,1750 , 'Ceftizoxime 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ceftizoxime 30 μg(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ceftizoxime 30 μg' ,1760 , 'Ceftizoxime 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ceftizoxime 30 μg(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ceftizoxime 30 μg' ,1770 , 'Ceftizoxime 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ceftizoxime 30 μg(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ceftizoxime 30 μg' ,1780 , 'Ceftizoxime 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ceftizoxime 30 μg(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ceftizoxime 30 μg' ,1790 , 'Ceftizoxime 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ceftizoxime 30 μg(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ceftizoxime 30 μg' ,1800 , 'Ceftizoxime 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Chloramfenicol 30 μg(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Chloramfenicol 30 μ' ,1810 , 'Chloramfenicol 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Chloramfenicol 30 μg(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Chloramfenicol 30 μ' ,1820 , 'Chloramfenicol 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Chloramfenicol 30 μg(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Chloramfenicol 30 μ' ,1830 , 'Chloramfenicol 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Chloramfenicol 30 μg(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Chloramfenicol 30 μ' ,1840 , 'Chloramfenicol 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Chloramfenicol 30 μg(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Chloramfenicol 30 μ' ,1850 , 'Chloramfenicol 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Chloramfenicol 30 μg(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Chloramfenicol 30 μ' ,1860 , 'Chloramfenicol 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ciprofloxacine 5 μg(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ciprofloxacine 5 μg' ,1870 , 'Ciprofloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ciprofloxacine 5 μg(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ciprofloxacine 5 μg' ,1880 , 'Ciprofloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ciprofloxacine 5 μg(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ciprofloxacine 5 μg' ,1890 , 'Ciprofloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ciprofloxacine 5 μg(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ciprofloxacine 5 μg' ,1900 , 'Ciprofloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ciprofloxacine 5 μg(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ciprofloxacine 5 μg' ,1910 , 'Ciprofloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ciprofloxacine 5 μg(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ciprofloxacine 5 μg' ,1920 , 'Ciprofloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Colistine 50 μg(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Colistine 50 μg' ,1930 , 'Colistine 50 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Colistine 50 μg(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Colistine 50 μg' ,1940 , 'Colistine 50 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Colistine 50 μg(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Colistine 50 μg' ,1950 , 'Colistine 50 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Colistine 50 μg(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Colistine 50 μg' ,1960 , 'Colistine 50 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Colistine 50 μg(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Colistine 50 μg' ,1970 , 'Colistine 50 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Colistine 50 μg(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Colistine 50 μg' ,1980 , 'Colistine 50 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Enoxacine 50 μg(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Enoxacine 50 μg' ,1990 , 'Enoxacine 50 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Enoxacine 50 μg(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Enoxacine 50 μg' ,2000 , 'Enoxacine 50 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Enoxacine 50 μg(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Enoxacine 50 μg' ,2010 , 'Enoxacine 50 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Enoxacine 50 μg(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Enoxacine 50 μg' ,2020 , 'Enoxacine 50 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Enoxacine 50 μg(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Enoxacine 50 μg' ,2030 , 'Enoxacine 50 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Enoxacine 50 μg(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Enoxacine 50 μg' ,2040 , 'Enoxacine 50 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Erythromycine 15 UI(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Erythromycine 15 UI' ,2050 , 'Erythromycine 15 UI' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Erythromycine 15 UI(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Erythromycine 15 UI' ,2060 , 'Erythromycine 15 UI' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Erythromycine 15 UI(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Erythromycine 15 UI' ,2070 , 'Erythromycine 15 UI' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Erythromycine 15 UI(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Erythromycine 15 UI' ,2080 , 'Erythromycine 15 UI' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Erythromycine 15 UI(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Erythromycine 15 UI' ,2090 , 'Erythromycine 15 UI' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Erythromycine 15 UI(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Erythromycine 15 UI' ,2100 , 'Erythromycine 15 UI' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Fosfomycine 50 μg(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Fosfomycine 50 μg' ,2110 , 'Fosfomycine 50 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Fosfomycine 50 μg(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Fosfomycine 50 μg' ,2120 , 'Fosfomycine 50 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Fosfomycine 50 μg(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Fosfomycine 50 μg' ,2130 , 'Fosfomycine 50 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Fosfomycine 50 μg(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Fosfomycine 50 μg' ,2140 , 'Fosfomycine 50 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Fosfomycine 50 μg(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Fosfomycine 50 μg' ,2150 , 'Fosfomycine 50 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Fosfomycine 50 μg(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Fosfomycine 50 μg' ,2160 , 'Fosfomycine 50 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Gentamicine 15 μg(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Gentamicine 15 μg' ,2170 , 'Gentamicine 15 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Gentamicine 15 μg(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Gentamicine 15 μg' ,2180 , 'Gentamicine 15 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Gentamicine 15 μg(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Gentamicine 15 μg' ,2190 , 'Gentamicine 15 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Gentamicine 15 μg(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Gentamicine 15 μg' ,2200 , 'Gentamicine 15 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Gentamicine 15 μg(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Gentamicine 15 μg' ,2210 , 'Gentamicine 15 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Gentamicine 15 μg(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Gentamicine 15 μg' ,2220 , 'Gentamicine 15 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Lincomycine 15 μg(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Lincomycine 15 μg' ,2230 , 'Lincomycine 15 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Lincomycine 15 μg(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Lincomycine 15 μg' ,2240 , 'Lincomycine 15 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Lincomycine 15 μg(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Lincomycine 15 μg' ,2250 , 'Lincomycine 15 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Lincomycine 15 μg(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Lincomycine 15 μg' ,2260 , 'Lincomycine 15 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Lincomycine 15 μg(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Lincomycine 15 μg' ,2270 , 'Lincomycine 15 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Lincomycine 15 μg(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Lincomycine 15 μg' ,2280 , 'Lincomycine 15 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Levofloxacine 5 μg(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Levofloxacine 5 μg' ,2290 , 'Levofloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Levofloxacine 5 μg(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Levofloxacine 5 μg' ,2300 , 'Levofloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Levofloxacine 5 μg(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Levofloxacine 5 μg' ,2310 , 'Levofloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Levofloxacine 5 μg(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Levofloxacine 5 μg' ,2320 , 'Levofloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Levofloxacine 5 μg(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Levofloxacine 5 μg' ,2330 , 'Levofloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Levofloxacine 5 μg(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Levofloxacine 5 μg' ,2340 , 'Levofloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Lomefloxacine 5 μg(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Lomefloxacine 5 μg' ,2350 , 'Lomefloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Lomefloxacine 5 μg(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Lomefloxacine 5 μg' ,2360 , 'Lomefloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Lomefloxacine 5 μg(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Lomefloxacine 5 μg' ,2370 , 'Lomefloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Lomefloxacine 5 μg(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Lomefloxacine 5 μg' ,2380 , 'Lomefloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Lomefloxacine 5 μg(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Lomefloxacine 5 μg' ,2390 , 'Lomefloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Lomefloxacine 5 μg(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Lomefloxacine 5 μg' ,2400 , 'Lomefloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Mecillinam 10 μg(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Mecillinam 10 μg' ,2410 , 'Mecillinam 10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Mecillinam 10 μg(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Mecillinam 10 μg' ,2420 , 'Mecillinam 10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Mecillinam 10 μg(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Mecillinam 10 μg' ,2430 , 'Mecillinam 10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Mecillinam 10 μg(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Mecillinam 10 μg' ,2440 , 'Mecillinam 10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Mecillinam 10 μg(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Mecillinam 10 μg' ,2450 , 'Mecillinam 10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Mecillinam 10 μg(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Mecillinam 10 μg' ,2460 , 'Mecillinam 10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Meropeneme 10 μg(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Meropeneme 10 μg' ,2470 , 'Meropeneme 10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Meropeneme 10 μg(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Meropeneme 10 μg' ,2480 , 'Meropeneme 10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Meropeneme 10 μg(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Meropeneme 10 μg' ,2490 , 'Meropeneme 10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Meropeneme 10 μg(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Meropeneme 10 μg' ,2500 , 'Meropeneme 10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Meropeneme 10 μg(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Meropeneme 10 μg' ,2510 , 'Meropeneme 10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Meropeneme 10 μg(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Meropeneme 10 μg' ,2520 , 'Meropeneme 10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Moxalactam(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Moxalactam' ,2530 , 'Moxalactam' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Moxalactam(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Moxalactam' ,2540 , 'Moxalactam' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Moxalactam(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Moxalactam' ,2550 , 'Moxalactam' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Moxalactam(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Moxalactam' ,2560 , 'Moxalactam' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Moxalactam(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Moxalactam' ,2570 , 'Moxalactam' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Moxalactam(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Moxalactam' ,2580 , 'Moxalactam' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Moxifloxacine 5 μg(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Moxifloxacine 5 μg' ,2590 , 'Moxifloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Moxifloxacine 5 μg(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Moxifloxacine 5 μg' ,2600 , 'Moxifloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Moxifloxacine 5 μg(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Moxifloxacine 5 μg' ,2610 , 'Moxifloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Moxifloxacine 5 μg(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Moxifloxacine 5 μg' ,2620 , 'Moxifloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Moxifloxacine 5 μg(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Moxifloxacine 5 μg' ,2630 , 'Moxifloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Nitrofuranes 300 μg(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Nitrofuranes 300 μg' ,2640 , 'Nitrofuranes 300 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Nitrofuranes 300 μg(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Nitrofuranes 300 μg' ,2650 , 'Nitrofuranes 300 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Nitrofuranes 300 μg(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Nitrofuranes 300 μg' ,2660 , 'Nitrofuranes 300 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Nitrofuranes 300 μg(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Nitrofuranes 300 μg' ,2670 , 'Nitrofuranes 300 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Nitrofuranes 300 μg(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Nitrofuranes 300 μg' ,2680 , 'Nitrofuranes 300 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Nitrofuranes 300 μg(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Nitrofuranes 300 μg' ,2690 , 'Nitrofuranes 300 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Norfloxacine 5 μg(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Norfloxacine 5 μg' ,2700 , 'Norfloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Norfloxacine 5 μg(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Norfloxacine 5 μg' ,2710 , 'Norfloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Norfloxacine 5 μg(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Norfloxacine 5 μg' ,2720 , 'Norfloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Norfloxacine 5 μg(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Norfloxacine 5 μg' ,2730 , 'Norfloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Norfloxacine 5 μg(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Norfloxacine 5 μg' ,2740 , 'Norfloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Norfloxacine 5 μg(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Norfloxacine 5 μg' ,2750 , 'Norfloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Oxacilline 1 μg(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Oxacilline 1 μg' ,2760 , 'Oxacilline 1 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Oxacilline 1 μg(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Oxacilline 1 μg' ,2770 , 'Oxacilline 1 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Oxacilline 1 μg(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Oxacilline 1 μg' ,2780 , 'Oxacilline 1 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Oxacilline 1 μg(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Oxacilline 1 μg' ,2790 , 'Oxacilline 1 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Oxacilline 1 μg(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Oxacilline 1 μg' ,2800 , 'Oxacilline 1 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Oxacilline 1 μg(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Oxacilline 1 μg' ,2810 , 'Oxacilline 1 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Oxacilline 5 μg(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Oxacilline 5 μg' ,2820 , 'Oxacilline 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Oxacilline 5 μg(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Oxacilline 5 μg' ,2830 , 'Oxacilline 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Oxacilline 5 μg(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Oxacilline 5 μg' ,2840 , 'Oxacilline 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Oxacilline 5 μg(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Oxacilline 5 μg' ,2850 , 'Oxacilline 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Oxacilline 5 μg(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Oxacilline 5 μg' ,2860 , 'Oxacilline 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Oxacilline 5 μg(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Oxacilline 5 μg' ,2870 , 'Oxacilline 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ofloxacine 5 μg(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ofloxacine 5 μg' ,2880 , 'Ofloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ofloxacine 5 μg(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ofloxacine 5 μg' ,2890 , 'Ofloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ofloxacine 5 μg(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ofloxacine 5 μg' ,2900 , 'Ofloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ofloxacine 5 μg(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ofloxacine 5 μg' ,2910 , 'Ofloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ofloxacine 5 μg(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ofloxacine 5 μg' ,2920 , 'Ofloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ofloxacine 5 μg(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ofloxacine 5 μg' ,2930 , 'Ofloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Pefloxacine 5 μg(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Pefloxacine 5 μg' ,2940 , 'Pefloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Pefloxacine 5 μg(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Pefloxacine 5 μg' ,2950 , 'Pefloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Pefloxacine 5 μg(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Pefloxacine 5 μg' ,2960 , 'Pefloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Pefloxacine 5 μg(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Pefloxacine 5 μg' ,2970 , 'Pefloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Pefloxacine 5 μg(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Pefloxacine 5 μg' ,2980 , 'Pefloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Pefloxacine 5 μg(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Pefloxacine 5 μg' ,2990 , 'Pefloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Penicilline G 6 μg (10 UI)(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Penicilline G 6 μg ' ,3000 , 'Penicilline G 6 μg (10 UI)' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Penicilline G 6 μg (10 UI)(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Penicilline G 6 μg ' ,3010 , 'Penicilline G 6 μg (10 UI)' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Penicilline G 6 μg (10 UI)(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Penicilline G 6 μg ' ,3020 , 'Penicilline G 6 μg (10 UI)' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Penicilline G 6 μg (10 UI)(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Penicilline G 6 μg ' ,3030 , 'Penicilline G 6 μg (10 UI)' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Penicilline G 6 μg (10 UI)(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Penicilline G 6 μg ' ,3040 , 'Penicilline G 6 μg (10 UI)' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Penicilline G 6 μg (10 UI)(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Penicilline G 6 μg ' ,3050 , 'Penicilline G 6 μg (10 UI)' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Piperacilline 75 μg(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Piperacilline 75 μg' ,3060 , 'Piperacilline 75 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Piperacilline 75 μg(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Piperacilline 75 μg' ,3070 , 'Piperacilline 75 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Piperacilline 75 μg(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Piperacilline 75 μg' ,3080 , 'Piperacilline 75 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Piperacilline 75 μg(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Piperacilline 75 μg' ,3090 , 'Piperacilline 75 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Piperacilline 75 μg(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Piperacilline 75 μg' ,3100 , 'Piperacilline 75 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Piperacilline 75 μg(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Piperacilline 75 μg' ,3110 , 'Piperacilline 75 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Pristinamycine 15 μg(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Pristinamycine 15 μ' ,3120 , 'Pristinamycine 15 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Pristinamycine 15 μg(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Pristinamycine 15 μ' ,3130 , 'Pristinamycine 15 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Pristinamycine 15 μg(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Pristinamycine 15 μ' ,3140 , 'Pristinamycine 15 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Pristinamycine 15 μg(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Pristinamycine 15 μ' ,3150 , 'Pristinamycine 15 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Pristinamycine 15 μg(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Pristinamycine 15 μ' ,3160 , 'Pristinamycine 15 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Pristinamycine 15 μg(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Pristinamycine 15 μ' ,3170 , 'Pristinamycine 15 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Quinupristine- Dalfopristine 15 μg(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Quinupristine- Dalfo' ,3180 , 'Quinupristine- Dalfopristine 15 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Quinupristine- Dalfopristine 15 μg(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Quinupristine- Dalfo' ,3190 , 'Quinupristine- Dalfopristine 15 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Quinupristine- Dalfopristine 15 μg(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Quinupristine- Dalfo' ,3200 , 'Quinupristine- Dalfopristine 15 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Quinupristine- Dalfopristine 15 μg(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Quinupristine- Dalfo' ,3210 , 'Quinupristine- Dalfopristine 15 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Quinupristine- Dalfopristine 15 μg(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Quinupristine- Dalfo' ,3220 , 'Quinupristine- Dalfopristine 15 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Quinupristine- Dalfopristine 15 μg(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Quinupristine- Dalfo' ,3230 , 'Quinupristine- Dalfopristine 15 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Rifampicine 30 μg(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Rifampicine 30 μg' ,3240 , 'Rifampicine 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Rifampicine 30 μg(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Rifampicine 30 μg' ,3250 , 'Rifampicine 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Rifampicine 30 μg(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Rifampicine 30 μg' ,3260 , 'Rifampicine 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Rifampicine 30 μg(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Rifampicine 30 μg' ,3270 , 'Rifampicine 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Rifampicine 30 μg(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Rifampicine 30 μg' ,3280 , 'Rifampicine 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Rifampicine 30 μg(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Rifampicine 30 μg' ,3290 , 'Rifampicine 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Sparfloxacine 5 μg(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Sparfloxacine 5 μg' ,3300 , 'Sparfloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Sparfloxacine 5 μg(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Sparfloxacine 5 μg' ,3310 , 'Sparfloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Sparfloxacine 5 μg(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Sparfloxacine 5 μg' ,3320 , 'Sparfloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Sparfloxacine 5 μg(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Sparfloxacine 5 μg' ,3330 , 'Sparfloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Sparfloxacine 5 μg(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Sparfloxacine 5 μg' ,3340 , 'Sparfloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Sparfloxacine 5 μg(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Sparfloxacine 5 μg' ,3350 , 'Sparfloxacine 5 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Sulfamethoxazole /Trimethroprime23.75 /1,25 μg(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Sulfamethoxazole /Tr' ,3360 , 'Sulfamethoxazole /Trimethroprime23.75 /1,25 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Sulfamethoxazole /Trimethroprime23.75 /1,25 μg(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Sulfamethoxazole /Tr' ,3370 , 'Sulfamethoxazole /Trimethroprime23.75 /1,25 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Sulfamethoxazole /Trimethroprime23.75 /1,25 μg(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Sulfamethoxazole /Tr' ,3380 , 'Sulfamethoxazole /Trimethroprime23.75 /1,25 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Sulfamethoxazole /Trimethroprime23.75 /1,25 μg(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Sulfamethoxazole /Tr' ,3390 , 'Sulfamethoxazole /Trimethroprime23.75 /1,25 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Sulfamethoxazole /Trimethroprime23.75 /1,25 μg(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Sulfamethoxazole /Tr' ,3400 , 'Sulfamethoxazole /Trimethroprime23.75 /1,25 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Sulfamethoxazole /Trimethroprime23.75 /1,25 μg(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Sulfamethoxazole /Tr' ,3410 , 'Sulfamethoxazole /Trimethroprime23.75 /1,25 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Teiclopanine 30 μg(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Teiclopanine 30 μg' ,3420 , 'Teiclopanine 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Teiclopanine 30 μg(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Teiclopanine 30 μg' ,3430 , 'Teiclopanine 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Teiclopanine 30 μg(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Teiclopanine 30 μg' ,3440 , 'Teiclopanine 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Teiclopanine 30 μg(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Teiclopanine 30 μg' ,3450 , 'Teiclopanine 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Teiclopanine 30 μg(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Teiclopanine 30 μg' ,3460 , 'Teiclopanine 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Teiclopanine 30 μg(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Teiclopanine 30 μg' ,3470 , 'Teiclopanine 30 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Tetracycline 30 UI(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Tetracycline 30 UI' ,3480 , 'Tetracycline 30 UI' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Tetracycline 30 UI(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Tetracycline 30 UI' ,3490 , 'Tetracycline 30 UI' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Tetracycline 30 UI(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Tetracycline 30 UI' ,3500 , 'Tetracycline 30 UI' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Tetracycline 30 UI(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Tetracycline 30 UI' ,3510 , 'Tetracycline 30 UI' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Tetracycline 30 UI(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Tetracycline 30 UI' ,3520 , 'Tetracycline 30 UI' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Tetracycline 30 UI(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Tetracycline 30 UI' ,3530 , 'Tetracycline 30 UI' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ticarcilline 75 μg(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ticarcilline 75 μg' ,3540 , 'Ticarcilline 75 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ticarcilline 75 μg(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ticarcilline 75 μg' ,3550 , 'Ticarcilline 75 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ticarcilline 75 μg(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ticarcilline 75 μg' ,3560 , 'Ticarcilline 75 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ticarcilline 75 μg(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ticarcilline 75 μg' ,3570 , 'Ticarcilline 75 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ticarcilline 75 μg(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ticarcilline 75 μg' ,3580 , 'Ticarcilline 75 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ticarcilline 75 μg(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Ticarcilline 75 μg' ,3590 , 'Ticarcilline 75 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Tobramycine 10 μg(Selles)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Tobramycine 10 μg' ,3600 , 'Tobramycine 10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Tobramycine 10 μg(Ecouvillon Naso-Pharynge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Tobramycine 10 μg' ,3610 , 'Tobramycine 10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Tobramycine 10 μg(Ecouvillon Pharinge)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Tobramycine 10 μg' ,3620 , 'Tobramycine 10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Tobramycine 10 μg(Ecouvillon Nasal)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Tobramycine 10 μg' ,3630 , 'Tobramycine 10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Tobramycine 10 μg(Eau de riviere)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Tobramycine 10 μg' ,3640 , 'Tobramycine 10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Tobramycine 10 μg(Sang)' , '' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Tobramycine 10 μg' ,3650 , 'Tobramycine 10 μg' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Echantillon(Free text)' , 'Echantillon' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Echantillon' ,3660 , 'Echantillon' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Colaration de Gram(Free text)' , 'Colaration de Gram' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Colaration de Gram' ,3670 , 'Colaration de Gram' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Culture(Free text)' , 'Culture' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Culture' ,3680 , 'Culture' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Couleur(Selles)' , 'Couleur' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Parasitology' ) ,'Couleur' ,3690 , 'Couleur' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Consistance(Selles)' , 'Consistance' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Parasitology' ) ,'Consistance' ,3700 , 'Consistance' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Sang Occulte(Selles)' , 'Sang Occulte' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Parasitology' ) ,'Sang Occulte' ,3710 , 'Sang Occulte' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Bacteries(Selles)' , 'Bacteries' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Parasitology' ) ,'Bacteries' ,3720 , 'Bacteries' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Levures simples(Selles)' , 'Levures Simple' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Parasitology' ) ,'Levures simples' ,3730 , 'Levures simples' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Levures bourgeonantes(Selles)' , 'Levure Bourg' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Parasitology' ) ,'Levures bourgeonante' ,3740 , 'Levures bourgeonantes' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Examen Microscopique direct(Selles)' , 'Examen microscopique direct' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Parasitology' ) ,'Examen Microscopique' ,3750 , 'Examen Microscopique direct' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Examen Microscopique après concentration(Selles)' , 'Examen microscopique apres concentration' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Parasitology' ) ,'Examen Microscopique' ,3760 , 'Examen Microscopique après concentration' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , $$Recherche d'Oxyures (Scotch Tape)(Selles)$$ , $$Recherche d'Oxyures (Scotch Tape)$$ , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Parasitology' ) ,$$Recherche d'Oxyures $$ ,3770 , $$Recherche d'Oxyures (Scotch Tape)$$ , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Ziehl Neelsen modifiee(Selles)' , 'Ziehl Neelsen modifiee' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Parasitology' ) ,'Ziehl Neelsen modifi' ,3780 , 'Ziehl Neelsen modifiee' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Malaria(Sang)' , 'Plasmodiun Esp' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Parasitology' ) ,'Malaria' ,3790 , 'Malaria' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Malaria Test Rapide(Sang)' , 'Malaria Test Rapide' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Parasitology' ) ,'Malaria Test Rapide' ,3800 , 'Malaria Test Rapide' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Recherche de Microfilaires(Sang)' , 'Microfilaires' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Parasitology' ) ,'Recherche de Microfi' ,3810 , 'Recherche de Microfilaires' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Recherche de BARR par Ziehl Neelsen Specimen 1(Sputum)' , 'Recherche BAAR par Ziehl Neelsen Specimen 1' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Mycobacteriology' ) ,'Recherche de BARR pa' ,3820 , 'Recherche de BARR par Ziehl Neelsen Specimen 1' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Recherche de BARR par Ziehl Neelsen Specimen 2(Sputum)' , 'Recherche BAAR par Ziehl Neelsen Specimen 2' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Mycobacteriology' ) ,'Recherche de BARR pa' ,3830 , 'Recherche de BARR par Ziehl Neelsen Specimen 2' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Recherche de BARR par Ziehl Neelsen Specimen 3(Sputum)' , 'Recherche BAAR Ziehl Neelsen Specimen 3' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Mycobacteriology' ) ,'Recherche de BARR pa' ,3840 , 'Recherche de BARR par Ziehl Neelsen Specimen 3' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Recherche de BARR par Fluorochrome Specimen 1(Sputum)' , 'Recherche de BARR par Fluorochrome Specimen 1' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Mycobacteriology' ) ,'Recherche de BARR pa' ,3850 , 'Recherche de BARR par Fluorochrome Specimen 1' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Recherche de BARR par Fluorochrome Specimen 2(Sputum)' , 'Recherche de BARR par Fluorochrome Specimen 2' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Mycobacteriology' ) ,'Recherche de BARR pa' ,3860 , 'Recherche de BARR par Fluorochrome Specimen 2' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Recherche de BARR par Fluorochrome Specimen 3(Sputum)' , 'Recherche de BARR par Fluorochrome Specimen 3' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Mycobacteriology' ) ,'Recherche de BARR pa' ,3870 , 'Recherche de BARR par Fluorochrome Specimen 3' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Culture de mycobacteries Solide(Sputum)' , 'Culture de mycobacteries solide' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Mycobacteriology' ) ,'Culture de mycobacte' ,3880 , 'Culture de mycobacteries Solide' , '');
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name, loinc )
	VALUES ( nextval( 'test_seq' ) , null , 'Culture de mycobacteries liquide(Sputum)' , 'Culture de mycobacteries liquide' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Mycobacteriology' ) ,'Culture de mycobacte' ,3890 , 'Culture de mycobacteries liquide' , '');
