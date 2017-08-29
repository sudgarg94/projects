-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: webdesign
-- ------------------------------------------------------
-- Server version	5.6.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `appointmenttable`
--

DROP TABLE IF EXISTS `appointmenttable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `appointmenttable` (
  `appointmentid` int(11) NOT NULL AUTO_INCREMENT,
  `patientfullname` varchar(255) DEFAULT NULL,
  `contactnumber` varchar(255) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `doctorid` int(11) DEFAULT NULL,
  PRIMARY KEY (`appointmentid`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointmenttable`
--

LOCK TABLES `appointmenttable` WRITE;
/*!40000 ALTER TABLE `appointmenttable` DISABLE KEYS */;
INSERT INTO `appointmenttable` VALUES (1,'Hitesh Kumar','9789830035','Fever Related',5),(2,'Vipul Sharma','9098778265','Muscle Pain',5),(3,'Gaurang Shah','8572695431','Cold Related',5),(21,'Vipul','8767283591','Head ache related',5),(22,'vipul','8578004459','suffering from headache',5);
/*!40000 ALTER TABLE `appointmenttable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feedback` (
  `name` varchar(45) NOT NULL,
  `message` varchar(45) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` VALUES ('John','Nice Website Helpful Information'),('Nishant','Very much helpful information '),('Raj','Nice information and very much helpful'),('Troy','Very good information'),('vipul','helped me find a doctor well');
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `finding_store`
--

DROP TABLE IF EXISTS `finding_store`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `finding_store` (
  `Store_ID` int(11) NOT NULL,
  `Store_Name` varchar(45) DEFAULT NULL COMMENT '	',
  `City` varchar(45) DEFAULT NULL COMMENT '	',
  `Store_Address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Store_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `finding_store`
--

LOCK TABLES `finding_store` WRITE;
/*!40000 ALTER TABLE `finding_store` DISABLE KEYS */;
INSERT INTO `finding_store` VALUES (1,'Walgreens','Boston','1358 Horace Crest'),(2,'CVS','New York','497 Katarina Greens'),(3,'Star Market','Texas','50 Park Drive'),(4,'Alp Medical','NH','2091 Revere St.'),(5,'Healthcare','North Carolina','3097 Boylston Ave.'),(6,'CVS','Chicago','2119 Rockshore Road'),(7,'Fit Medical','NJ','590 Harvard Sq.'),(8,'CVS','NJ','62 State St.'),(9,'Walgreens','NH','6011 Somerville Road'),(10,'Star Pharmacy','Chicago','2345 Melvin Road'),(11,'The Medical Store','Boston','75 Alphonsus St.'),(12,'AA Medical Store','New York','11 Lion St.'),(13,'Sullivan Pharmacy','Texas','4567 Roackport Ave.'),(14,'CVS','North Carolina','505 Downtown Crossing'),(15,'Seven Eleven','Boston','6 Germain St.');
/*!40000 ALTER TABLE `finding_store` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `findingdoctor`
--

DROP TABLE IF EXISTS `findingdoctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `findingdoctor` (
  `Doctor_Id` int(11) NOT NULL,
  `Doctor_Name` varchar(45) DEFAULT NULL,
  `City` varchar(45) DEFAULT NULL,
  `Specialization` varchar(45) DEFAULT NULL,
  `Clinic_Address` varchar(45) DEFAULT NULL,
  `Email_Id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Doctor_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `findingdoctor`
--

LOCK TABLES `findingdoctor` WRITE;
/*!40000 ALTER TABLE `findingdoctor` DISABLE KEYS */;
INSERT INTO `findingdoctor` VALUES (1,'Sam Michael','Boston','Gynaecologist','8246 Graham Grove','sam@doctor.com'),(2,'Shannon Carter','New York','Dentist','8131 Katelyn Cape','shannoncarter@doctor.com'),(3,'Dara Ayers','NJ','MBBS','5068 Dictum Av.','avers.d@doctor.com'),(4,'Melvin Byrd','Texas','MBBS','1893 Risus. St.','melvin@doctor.com'),(5,'Hanae Ellison','Chicago','Cardiologist','3806 Hymenaeos. Road','hanae.e@doctor.com'),(6,'Irene Kerr','NH','Optician','8186 Risus. Rd','kerr@doctor.com'),(7,'Cade Townsend','North Carolina','Dentist','5134 Felis Avenue','cade@doctor.com'),(8,'Elliott Ward','Boston','Dermatologist','15 Smith St.','eward@doctor.com'),(9,'Kato Weber','NH','MBBS','1626 Sed Rd.','weberk@doctor.com'),(10,'Patience Goff','Chicago','Dentist','3488 Vel Rd.','goff.p@doctor.com'),(11,'Jeanette Nichols','Texas','Gynaecologist','3407 Ut Av.','nicholsj@doctor.com'),(12,'Upton Trujillo','North Carolina','MBBS','122 Consequat Rd.','uptont@doctor.com'),(13,'Gail Hull','NJ','Dentist','860 Sapien St.','hullg@doctor.com'),(14,'Clayton Hansen','NH','Dermatologist','80 Malesuada Ave','clayhan@doctor.com'),(15,'Nelson Rox','Boston','Optician','404 Et Road','roxnel@doctor.com');
/*!40000 ALTER TABLE `findingdoctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicine`
--

DROP TABLE IF EXISTS `medicine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medicine` (
  `Medicine_Id` int(11) NOT NULL,
  `Medicine_Name` varchar(45) DEFAULT NULL,
  `Compositions` varchar(45) DEFAULT NULL,
  `Symptoms` varchar(45) DEFAULT NULL,
  `BrandName` varchar(45) DEFAULT NULL,
  `Price` int(11) DEFAULT NULL,
  PRIMARY KEY (`Medicine_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicine`
--

LOCK TABLES `medicine` WRITE;
/*!40000 ALTER TABLE `medicine` DISABLE KEYS */;
INSERT INTO `medicine` VALUES (1,'Paracetamol','paracetamol 650 mg, caffeine 50 mg','Fever, headache, pain during menstruation, Ar','Crocin Advance',10),(2,'Vicks','camphor 4.8%, Eucalyptus oil 1.2%, Menthol 2.','Cough, Cold','Vicks',15),(3,'Paracetamol','paracetamol 650 mg, caffeine 50 mg','Fever, headache, pain during menstruation, Ar','Crocin Standard',20),(4,'Cialis','actose monohydrate, croscarmellose sodium','Erectile dysfunction	','Lilly Icos',89),(5,'Lunesta','calcium phosphate, colloidal silicon dioxide,','Insomnia','Generic',30),(6,'Prezista','raltegravir, calcium phosphate dibasic anhydr','Body rash,fever, sore throat, severe headache','Johnson & Johnson	',21),(7,'Lovaza',' ethyl esters of eicosapentaenoic acid, docos','Cholesterol','GlaxoSmithKline	',19),(8,'Abilify',' cornstarch, hydroxypropyl cellulose, lactose','Psychosis, depression','Generic',15),(9,'Eprex','Sodium chloride, sodium citrate dihydrate, ci','Fatigue. Weakness. Pale or yellowish skin. Ir','Johnson & Johnson	',31),(10,'Flovent HFA','fluticasone propionate','Coughing, Difficulty breathing. Chest tightne','GlaxoSmithKline	',8),(11,'Budesonide','fluticasone propionate','Coughing, Difficulty breathing. Chest tightne','Generic',19),(12,'Bevacizumab	','lactose, butylated hydroxytoluene, crospovido','Fever, Fatigue, weight loss','Avastin	',25),(13,'Tenofovir','raltegravir, calcium phosphate dibasic anhydr','Body rash,fever, sore throat, severe headache','Truvada	',55),(14,'Celecoxib	','croscarmellose sodium, edible inks, gelatin, ','Pain','Celebrex',6),(15,'Ezetimibe	',' ethyl esters of eicosapentaenoic acid, docos','Cholesterol','Zetia',41),(16,'Budesonide	','fluticasone propionate','Coughing, Difficulty breathing. Chest tightne','AstraZeneca',60),(17,'Vesicare	','solifenacin succinate, lactose monohydrate, c','Overactive bladder	','Astellas Pharma US	',35),(18,'Viagra','actose monohydrate, croscarmellose sodium','Erectile dysfunction','Pfizer',48),(19,'Suboxone','buprenorphine, naloxone','Pain, opioid addiction	','Reckitt Benckiser Pharmaceuticals Inc.',26),(20,'Alimta','lactose, butylated hydroxytoluene, crospovido','Fever, Fatigue, weight loss','Eli Lilly and Company',48),(21,'Isentress	','raltegravir, calcium phosphate dibasic anhydr','Body rash,fever, sore throat, severe headache','Merck & Co., Inc.',50),(22,'Xeloda','lactose, butylated hydroxytoluene, crospovido','Fever, Fatigue, weight loss','Generic',12),(23,'Afinitor	','lactose, butylated hydroxytoluene, crospovido','Fever, Fatigue, weight loss','Novartis',30),(24,'Tamiflu','monosodium citrate, saccharin sodium, sodium ','Severe aches in muscles and joints, Pain and ','Roche',40),(25,'Tamiflu','monosodium citrate, saccharin sodium, sodium ','Severe aches in muscles and joints, Pain and ','Chugai Pharmaceutical',32),(26,'Tamiflu','monosodium citrate, saccharin sodium, sodium ','Severe aches in muscles and joints, Pain and ','Hetero Drugs',25),(27,'Mirtazapine','colloidal silicon dioxide, corn starch, hypro','Depression','Remeron',13),(28,'Oxycodone','thebaine','Pain','OxyContin',19),(29,'Paroxetine','polacrilin potassium, microcrystalline cellul','Depression','Paxil',26),(30,'Lovastatin','cellulose, lactose, magnesium stearate, and s','Cholesterol','Mevacor',23),(31,'Pioglitazone','lactose monohydrate, crosscarmellose sodium, ','Diabetes','Actos',32),(32,'Codeine ',' powdered cellulose, magnesium stearate, sodi','Pain','Tylenol',9),(33,'Mometasone','aluminum starch octenylsuccinate (Gamma Irrad','Allergy','Nasonex',17),(34,'Venlafaxine','cellulose, ethylcellulose, gelatin, hypromell','Depression','Effexor',20),(35,'Ezetimibe','croscarmellose sodium NF, lactose monohydrate','Cholesterol','Zetia',39),(36,'Sitagliptin','microcrystalline cellulose, anhydrous dibasic','Diabetes','Januvia',28),(37,'Cetirizine','pregelatinized starch, lactose, maize starch','Allergy','Zyrtec',24),(38,'Nortriptyline','magnesium stearate, pregelatinized corn starc','Depression','Pamelor',45),(39,'Sumatriptan',' isocarboxazid, linezolid, methylene blue inj','Migraine','Imitrex',27),(40,'Fenofibrate','colloidal silicon dioxide, crospovidone, lact','Cholesterol','Tricor',38),(41,'Ticagrelor',' mannitol, dibasic calcium phosphate, sodium ','Heart disease','Brilinta',26),(42,'Saxagliptin','lactose monohydrate, microcrystalline cellulo','Diabetes','Onglyza',40),(43,'Amoxicillin + Clavulanate	','Colloidal silicon dioxide, hypromellose, magn','Bacteria Infection	','Augmentin',35),(44,'Adalimumab','40 mg adalimumab, 4.93 mg sodium chloride, 0.','Inflammation','Humira',18),(45,'Terazosin','corn starch, FD&C Yellow No. 6, lactose monoh','High Blood Pressure','Hytrin',11),(46,'Methocarbamol','Colloidal Silicon Dioxide, Lactose Monohydrat','Muscle pain','Robaxin',26),(47,'Desvenlafaxine','magnesium stearate, pregelatinized corn starc','Depression','Pristiq',39),(48,'Temazepam','FD&C Blue #1, FD&C Red #3, gelatin, lactose','Sleeping disorder','Restoril',15),(49,'Glipizide','lactose monohydrate, microcrystalline cellulo','Diabetes','Glucotrol',21),(50,'Bupropion','magnesium stearate, pregelatinized corn starc','Depression','Wellbutrin',14),(51,'Simvastatin','colloidal silicon dioxide, crospovidone, lact','Cholesterol','Zocor',36),(52,'Zolpidem','FD&C Blue #1, FD&C Red #3, gelatin, lactose','Sleeping disorder','Ambien',31),(53,'Tramadol','Colloidal Silicon Dioxide, Lactose Monohydrat','Pain','Ultram',29),(54,'Fluticasone','pregelatinized starch, lactose, maize starch','Allergy','Flonase',36),(55,'Loratadine','pregelatinized starch, lactose, maize starch','Allergy','Claritin',26);
/*!40000 ALTER TABLE `medicine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registeredoctors`
--

DROP TABLE IF EXISTS `registeredoctors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registeredoctors` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `passw` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `specialization` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registeredoctors`
--

LOCK TABLES `registeredoctors` WRITE;
/*!40000 ALTER TABLE `registeredoctors` DISABLE KEYS */;
INSERT INTO `registeredoctors` VALUES (1,'doctorname','doctor','doctor','some address','specialization'),(5,'Kamlesh Patel','kam','kam','Mumbai','MBBS'),(6,'Mike Shaw','mike','mike','Boston','Dentist'),(7,'Clarke Smallings','clark','clark','New York','Child Specialist'),(9,'manish','man','man','Mumbai','BDS'),(10,'vipul','krish','krish','adde','orthopedic');
/*!40000 ALTER TABLE `registeredoctors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'webdesign'
--

--
-- Dumping routines for database 'webdesign'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-22 16:50:13
