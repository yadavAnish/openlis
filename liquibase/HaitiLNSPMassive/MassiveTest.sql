INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Test Rapide VIH(Sang)' , 'VIH test Rap' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Test Rapide VIH' ,10 , 'Test Rapide VIH' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Test Rapide VIH(Serum)' , 'VIH test Rap' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Test Rapide VIH' ,20 , 'Test Rapide VIH' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Test Rapide VIH(Plasma)' , 'VIH test Rap' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Test Rapide VIH' ,30 , 'Test Rapide VIH' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Test Rapide VIH(DBS)' , 'VIH test Rap' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Test Rapide VIH' ,40 , 'Test Rapide VIH' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'VIH Elisa(Sang)' , 'Elisa' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'VIH Elisa' ,50 , 'VIH Elisa' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'VIH Elisa(Serum)' , 'Elisa' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'VIH Elisa' ,60 , 'VIH Elisa' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'VIH Elisa(Plasma)' , 'Elisa' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'VIH Elisa' ,70 , 'VIH Elisa' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'VIH Elisa(DBS)' , 'Elisa' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'VIH Elisa' ,80 , 'VIH Elisa' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'VIH Western Blot(Sang)' , 'HIV Blot' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'VIH Western Blot' ,90 , 'VIH Western Blot' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'VIH Western Blot(Serum)' , 'HIV Blot' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'VIH Western Blot' ,100 , 'VIH Western Blot' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'VIH Western Blot(Plasma)' , 'HIV Blot' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'VIH Western Blot' ,110 , 'VIH Western Blot' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'VIH Western Blot(DBS)' , 'HIV Blot' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'VIH Western Blot' ,120 , 'VIH Western Blot' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Rougeole(Serum)' , 'Rougoele' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Rougeole' ,130 , 'Rougeole' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Rougeole(Plasma)' , 'Rougoele' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Rougeole' ,140 , 'Rougeole' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Dengue(Serum)' , 'Duengue' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Dengue' ,150 , 'Dengue' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Dengue(Plasma)' , 'Duengue' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Dengue' ,160 , 'Dengue' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Rubeole(Serum)' , 'Rubeole' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Rubeole' ,170 , 'Rubeole' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Rubeole(Plasma)' , 'Rubeole' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Rubeole' ,180 , 'Rubeole' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Dengue NS1Ag(Serum)' , 'Dengue' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Dengue NS1Ag' ,190 , 'Dengue NS1Ag' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Dengue NS1Ag(Plasma)' , 'Dengue' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Dengue NS1Ag' ,200 , 'Dengue NS1Ag' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Hepatite A IgM(Serum)' , 'Hepatite A' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Hepatite A IgM' ,210 , 'Hepatite A IgM' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Hepatite A IgM(Plasma)' , 'Hepatite A' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Hepatite A IgM' ,220 , 'Hepatite A IgM' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Hepatite B Ag(Serum)' , 'Hepatite B' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Hepatite B Ag' ,230 , 'Hepatite B Ag' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Hepatite B Ag(Plasma)' , 'Hepatite B' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Hepatite B Ag' ,240 , 'Hepatite B Ag' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Hepatite C IgM(Serum)' , 'Hepatite C' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Hepatite C IgM' ,250 , 'Hepatite C IgM' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Hepatite C IgM(Plasma)' , 'Hepatite C' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Hepatite C IgM' ,260 , 'Hepatite C IgM' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Hepatite E IgM(Serum)' , 'Hepatite E' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Hepatite E IgM' ,270 , 'Hepatite E IgM' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Hepatite E IgM(Plasma)' , 'Hepatite E' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Hepatite E IgM' ,280 , 'Hepatite E IgM' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Influenza A/Immunofluoresence(Ecouvillon Nasal)' , 'Infl A' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Influenza A/Immunofl' ,290 , 'Influenza A/Immunofluoresence' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Influenza A/Immunofluoresence(Ecouvillon Naso-Pharynge)' , 'Infl A' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Influenza A/Immunofl' ,300 , 'Influenza A/Immunofluoresence' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Influenza A/Immunofluoresence(Aspiration Naso-Pharyngee)' , 'Infl A' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Influenza A/Immunofl' ,310 , 'Influenza A/Immunofluoresence' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Influenza B/Immunofluoresence(Ecouvillon Nasal)' , 'Infl B' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Influenza B/Immunofl' ,320 , 'Influenza B/Immunofluoresence' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Influenza B/Immunofluoresence(Ecouvillon Naso-Pharynge)' , 'Infl B' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Influenza B/Immunofl' ,330 , 'Influenza B/Immunofluoresence' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Influenza B/Immunofluoresence(Aspiration Naso-Pharyngee)' , 'Infl B' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Influenza B/Immunofl' ,340 , 'Influenza B/Immunofluoresence' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Para Influenza 1/Immunofluoresence(Ecouvillon Nasal)' , 'Para Infl 1' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Para Influenza 1/Imm' ,350 , 'Para Influenza 1/Immunofluoresence' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Para Influenza 1/Immunofluoresence(Ecouvillon Naso-Pharynge)' , 'Para Infl 1' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Para Influenza 1/Imm' ,360 , 'Para Influenza 1/Immunofluoresence' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Para Influenza 1/Immunofluoresence(Aspiration Naso-Pharyngee)' , 'Para Infl 1' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Para Influenza 1/Imm' ,370 , 'Para Influenza 1/Immunofluoresence' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Para Influenza 2/Immunofluoresence(Ecouvillon Nasal)' , 'Para Infl 2' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Para Influenza 2/Imm' ,380 , 'Para Influenza 2/Immunofluoresence' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Para Influenza 2/Immunofluoresence(Ecouvillon Naso-Pharynge)' , 'Para Infl 2' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Para Influenza 2/Imm' ,390 , 'Para Influenza 2/Immunofluoresence' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Para Influenza 2/Immunofluoresence(Aspiration Naso-Pharyngee)' , 'Para Infl 2' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Para Influenza 2/Imm' ,400 , 'Para Influenza 2/Immunofluoresence' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Para Influenza 3/Immunofluoresence(Ecouvillon Nasal)' , 'Para Infl 3' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Para Influenza 3/Imm' ,410 , 'Para Influenza 3/Immunofluoresence' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Para Influenza 3/Immunofluoresence(Ecouvillon Naso-Pharynge)' , 'Para Infl 3' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Para Influenza 3/Imm' ,420 , 'Para Influenza 3/Immunofluoresence' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Para Influenza 3/Immunofluoresence(Aspiration Naso-Pharyngee)' , 'Para Infl 3' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Para Influenza 3/Imm' ,430 , 'Para Influenza 3/Immunofluoresence' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'VR/ Immunofluoresence(Ecouvillon Nasal)' , 'VR' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'VR/ Immunofluoresenc' ,440 , 'VR/ Immunofluoresence' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'VR/ Immunofluoresence(Ecouvillon Naso-Pharynge)' , 'VR' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'VR/ Immunofluoresenc' ,450 , 'VR/ Immunofluoresence' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'VR/ Immunofluoresence(Aspiration Naso-Pharyngee)' , 'VR' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'VR/ Immunofluoresenc' ,460 , 'VR/ Immunofluoresence' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Adenovirus/Immunofluoresence(Ecouvillon Nasal)' , 'Adenovirus' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Adenovirus/Immunoflu' ,470 , 'Adenovirus/Immunofluoresence' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Adenovirus/Immunofluoresence(Ecouvillon Naso-Pharynge)' , 'Adenovirus' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Adenovirus/Immunoflu' ,480 , 'Adenovirus/Immunofluoresence' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Adenovirus/Immunofluoresence(Aspiration Naso-Pharyngee)' , 'Adenovirus' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Adenovirus/Immunoflu' ,490 , 'Adenovirus/Immunofluoresence' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Polio(Selles 1)' , 'Polio' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Polio' ,500 , 'Polio' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Polio(Selles 2)' , 'Polio' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Polio' ,510 , 'Polio' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Rotavirus(Selles)' , 'Rotavirus' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Rotavirus' ,520 , 'Rotavirus' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Syphilis RPR(Serum)' , 'RPR' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Syphilis RPR' ,530 , 'Syphilis RPR' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Syphilis TPHA(Serum)' , 'TPHA' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Virologie' ) ,'Syphilis TPHA' ,540 , 'Syphilis TPHA' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'VIH-1 PCR Qualitative(DBS)' , 'HIV PCR' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Biologie Moleculaire' ) ,'VIH-1 PCR Qualitativ' ,550 , 'VIH-1 PCR Qualitative' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'VIH-1 PCR Qualitative(Sang Total)' , 'HIV PCR' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Biologie Moleculaire' ) ,'VIH-1 PCR Qualitativ' ,560 , 'VIH-1 PCR Qualitative' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , ( select id from clinlims.unit_of_measure where name='Copies/ml') , 'VIH-1 Charge Virale(Plasma)' , 'Charge Virale' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Biologie Moleculaire' ) ,'VIH-1 Charge Virale' ,570 , 'VIH-1 Charge Virale' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Recherche de Virus Respiratoire-A(Ecouvillon Naso-Pharynge)' , 'Infl A' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Biologie Moleculaire' ) ,'Recherche de Virus R' ,580 , 'Recherche de Virus Respiratoire-A' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Recherche de Virus Respiratoire-B(Ecouvillon Naso-Pharynge)' , 'Infl B' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Biologie Moleculaire' ) ,'Recherche de Virus R' ,585 , 'Recherche de Virus Respiratoire-B' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , ( select id from clinlims.unit_of_measure where name='μl') , 'CD4  Compte Abs(Sang Total)' , 'CD4' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Hematology' ) ,'CD4  Compte Abs' ,590 , 'CD4  Compte Abs' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , ( select id from clinlims.unit_of_measure where name='%') , 'CD4 Compte en %(Sang Total)' , 'CD4%' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Hematology' ) ,'CD4 Compte en %' ,600 , 'CD4 Compte en %' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Coloration de Gramm(LCR)' , 'Gramm' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Coloration de Gramm' ,610 , 'Coloration de Gramm' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Coloration de Gramm(Selles)' , 'Gramm' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Coloration de Gramm' ,620 , 'Coloration de Gramm' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Coloration de Gramm(Ecouvillon Pharynge)' , 'Gramm' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Coloration de Gramm' ,630 , 'Coloration de Gramm' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Coloration de Gramm(Ecouvillon Naso-Pharynge)' , 'Gramm' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Coloration de Gramm' ,640 , 'Coloration de Gramm' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Coloration de Gramm(Sang)' , 'Gramm' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Coloration de Gramm' ,650 , 'Coloration de Gramm' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Leptospirose(Serum)' , 'Lepto' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Leptospirose' ,660 , 'Leptospirose' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Leptospirose(Plasma)' , 'Lepto' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Leptospirose' ,670 , 'Leptospirose' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Leptospirose(Sang)' , 'Lepto' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Leptospirose' ,680 , 'Leptospirose' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Leptospirose(Sang capillaire)' , 'Lepto' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Leptospirose' ,690 , 'Leptospirose' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Hemoculture(Sang)' , 'Hemoculture' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Hemoculture' ,700 , 'Hemoculture' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Serologie Salmonelle(Serum)' , 'Salmonelle' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Serologie Salmonelle' ,710 , 'Serologie Salmonelle' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Serologie Salmonelle(Plasma)' , 'Salmonelle' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Serologie Salmonelle' ,720 , 'Serologie Salmonelle' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Meningite Culture(LCR)' , 'Meningite Cul' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Meningite Culture' ,730 , 'Meningite Culture' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Meningite Test Rapide(LCR)' , 'Meningite Rapide' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Meningite Test Rapid' ,740 , 'Meningite Test Rapide' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Recherche de Salmonelle(Selles)' , 'Salmonelle' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Recherche de Salmone' ,750 , 'Recherche de Salmonelle' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Recherche de Shigelle(Selles)' , 'Shiguelle' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Recherche de Shigell' ,760 , 'Recherche de Shigelle' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Recherche de V.cholerea(Selles)' , 'Cholera' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Recherche de V.chole' ,770 , 'Recherche de V.cholerea' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Recherche de C. diphteriae(Ecouvillon Pharynge)' , 'Diphterie' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Recherche de C. diph' ,780 , 'Recherche de C. diphteriae' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Recherche de B. pertussis(Ecouvillon Naso-Pharynge)' , 'Bordetella' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Recherche de B. pert' ,790 , 'Recherche de B. pertussis' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , $$Sensibilite a l'Acide Nalixidique (NA 30)(Selles)$$ , 'Acide Nalix' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,$$Sensibilite a l'Acid$$ ,800 , $$Sensibilite a l'Acide Nalixidique (NA 30)$$ );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , $$Sensibilite a l'Ampiciline (AM10)(Selles)$$ , 'Ampiciline' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,$$Sensibilite a l'Ampi$$ ,810 , $$Sensibilite a l'Ampiciline (AM10)$$ );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Sensibilite a Amoxyline/Acide Clavulanique (NAC 30)(Selles)' , 'Amox/Clavu' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Sensibilite a Amoxyl' ,820 , 'Sensibilite a Amoxyline/Acide Clavulanique (NAC 30)' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Sensibilite Azithromycine (AZM15)(Selles)' , 'Azithromicine' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Sensibilite Azithrom' ,830 , 'Sensibilite Azithromycine (AZM15)' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Sensibilite a la Sulfaméthoxazole/triméthoprime (SXT25)(Selles)' , 'Sulfame/Trimetho' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Sensibilite a la Sul' ,840 , 'Sensibilite a la Sulfaméthoxazole/triméthoprime (SXT25)' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Sensibilite a la Tetracycline (TE 30)(Selles)' , 'Tetracycline' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Sensibilite a la Tet' ,850 , 'Sensibilite a la Tetracycline (TE 30)' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Sensibilite a la Ciprofloxacine (CIP5)(Selles)' , 'Ciprofloxacine' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Sensibilite a la Cip' ,860 , 'Sensibilite a la Ciprofloxacine (CIP5)' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Sensibilite Amoxyline/Acide Clavulanique (AMC 30)(Selles)' , 'Amox/Clavu' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Sensibilite Amoxylin' ,870 , 'Sensibilite Amoxyline/Acide Clavulanique (AMC 30)' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Sensibilite a la Ceftriaxone (CRO30)(Selles)' , 'Amox/Clavu' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Sensibilite a la Cef' ,880 , 'Sensibilite a la Ceftriaxone (CRO30)' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Sensibilite Gentamycine (CN10)(Selles)' , 'Gentamycine' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Sensibilite Gentamyc' ,890 , 'Sensibilite Gentamycine (CN10)' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Sensibilite Chloramphénicol (C30)(Selles)' , 'Chloramphenicol' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Sensibilite Chloramp' ,900 , 'Sensibilite Chloramphénicol (C30)' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Sensibilite Céfalotine (CF30)(Selles)' , 'Cefalotine' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Sensibilite Céfalot' ,910 , 'Sensibilite Céfalotine (CF30)' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Sensibilite a la Ceftazidime (CAZ30)(Selles)' , 'Ceftazidime' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Bacteria' ) ,'Sensibilite a la Cef' ,920 , 'Sensibilite a la Ceftazidime (CAZ30)' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Couleur(Selles)' , 'Couleur' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Parasitology' ) ,'Couleur' ,930 , 'Couleur' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Aspect(Selles)' , 'Aspect' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Parasitology' ) ,'Aspect' ,940 , 'Aspect' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Sang Occulte(Selles)' , 'Sang Occulte' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Parasitology' ) ,'Sang Occulte' ,950 , 'Sang Occulte' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Bacteries(Selles)' , 'Bacteries' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Parasitology' ) ,'Bacteries' ,960 , 'Bacteries' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Levures simples(Selles)' , 'Levures Simple' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Parasitology' ) ,'Levures simples' ,970 , 'Levures simples' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Levures bourgeonantes(Selles)' , 'Levure Bourg' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Parasitology' ) ,'Levures bourgeonante' ,980 , 'Levures bourgeonantes' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Recherche de Protozoaires(Selles)' , 'Protozoaires' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Parasitology' ) ,'Recherche de Protozo' ,990 , 'Recherche de Protozoaires' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'recherche de Metazoaires(Selles)' , 'Metazoaires' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Parasitology' ) ,'recherche de Metazoa' ,1000 , 'recherche de Metazoaires' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Scotch Tape(Selles)' , 'Scotch Tape' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Parasitology' ) ,'Scotch Tape' ,1010 , 'Scotch Tape' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Methode Kato(Selles)' , 'Kato' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Parasitology' ) ,'Methode Kato' ,1020 , 'Methode Kato' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Methode Willis(Selles)' , 'Willis' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Parasitology' ) ,'Methode Willis' ,1030 , 'Methode Willis' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Methode Baermann(Selles)' , 'Baermann' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Parasitology' ) ,'Methode Baermann' ,1040 , 'Methode Baermann' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Ritchie(Selles)' , 'Ritchie' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Parasitology' ) ,'Ritchie' ,1050 , 'Ritchie' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Ziehl Neelsen modifiee(Selles)' , 'Zeihl Neelsen' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Parasitology' ) ,'Ziehl Neelsen modifi' ,1060 , 'Ziehl Neelsen modifiee' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Recherche de Plasmodium- Especes(Sang)' , 'Plasmodiun Esp' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Parasitology' ) ,'Recherche de Plasmod' ,1070 , 'Recherche de Plasmodium- Especes' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Recherche de Plasmodium- Trophozoite(Sang)' , 'Plasmodiun Troph' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Parasitology' ) ,'Recherche de Plasmod' ,1080 , 'Recherche de Plasmodium- Trophozoite' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Recherche de Plasmodium- Gametocyte(Sang)' , 'Plasmodiun Game' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Parasitology' ) ,'Recherche de Plasmod' ,1090 , 'Recherche de Plasmodium- Gametocyte' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Recherche de Plasmodium- Schizonte(Sang)' , 'Plasmodiun Shi' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Parasitology' ) ,'Recherche de Plasmod' ,1100 , 'Recherche de Plasmodium- Schizonte' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Malaria Test Rapide(Sang)' , 'Malaria Test Rapide' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Parasitology' ) ,'Malaria Test Rapide' ,1110 , 'Malaria Test Rapide' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Recherche de Microfilaires(Sang)' , 'Microfilaires' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Parasitology' ) ,'Recherche de Microfi' ,1120 , 'Recherche de Microfilaires' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Recherche de BAAR par Zeihl Neelsen Specimen 1(Expectoration)' , 'Recherche BAAR #1' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Mycobacteriology' ) ,'Recherche de BAAR pa' ,1130 , 'Recherche de BAAR par Zeihl Neelsen Specimen 1' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Recherche de BAAR par Zeihl Neelsen Specimen 2(Expectoration)' , 'Recherche BAAR #2' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Mycobacteriology' ) ,'Recherche de BAAR pa' ,1140 , 'Recherche de BAAR par Zeihl Neelsen Specimen 2' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Recherche de BAAR par Zeihl Neelsen Specimen 3(Expectoration)' , 'Recherche BAAR #3' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Mycobacteriology' ) ,'Recherche de BAAR pa' ,1150 , 'Recherche de BAAR par Zeihl Neelsen Specimen 3' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Recherche de BAAR par Fluorochrome Specimen 1(Expectoration)' , 'Rech BAAR Fluo #1' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Mycobacteriology' ) ,'Recherche de BAAR pa' ,1160 , 'Recherche de BAAR par Fluorochrome Specimen 1' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Recherche de BAAR par Fluorochrome Specimen 2(Expectoration)' , 'Rech BAAR Fluo #2' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Mycobacteriology' ) ,'Recherche de BAAR pa' ,1170 , 'Recherche de BAAR par Fluorochrome Specimen 2' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Recherche de BAAR par Fluorochrome Specimen 3(Expectoration)' , 'Rech BAAR Fluo #3' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Mycobacteriology' ) ,'Recherche de BAAR pa' ,1180 , 'Recherche de BAAR par Fluorochrome Specimen 3' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Culture LJ/Ogawa(Expectoration)' , 'LJ / Ogawa' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Mycobacteriology' ) ,'Culture LJ/Ogawa' ,1190 , 'Culture LJ/Ogawa' );
INSERT INTO test( id,  uom_id, description, reporting_description, is_active, is_reportable, lastupdated, test_section_id, local_abbrev, sort_order, name )
	VALUES ( nextval( 'test_seq' ) , null , 'Culture en milieu liquide(Expectoration)' , 'Cult milieu Liqu' , 'Y' , 'N' , now() , (select id from clinlims.test_section where name = 'Mycobacteriology' ) ,'Culture en milieu li' ,1200 , 'Culture en milieu liquide' );
