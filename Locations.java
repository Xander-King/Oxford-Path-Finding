import java.util.HashMap;
import java.util.Map;

public enum Locations {

	YAGERSTADIUM(0, false),
	MILLETHALL(1, false),
	FLOWERHALL(2, false),
	MARTINDININGCOMMONS(3, false),
	HAHNEHALL(4, false),
	BRANDONHALL(5, false),
	HEPBURNHALL(6, false),
	MCFARLANDHALL(7, false),
	STUDENTATHLETECENTER(8, false),
	MARCUMHALL(9, false),
	BILLINGSHALL(10, false),
	WITHROWHALL(11, false),
	MIAMIINNHALL(12, false),
	MCKIEFIELD(13, false),
	HAYDENBASEBALLCENTER(14, false),
	PSYCHOLOGYBUILDING(15, true),
	GARDENCOMMONS(16, false),
	SYMMESHALL(17, false),
	FARMERSCHOOLOFBUSINESS(18, true),
	PEARSONHALL(19, true),
	ENGINEERINGBUILDING(20, true),
	GARLANDHALL(21, true),
	BENTONHALL(22, true),
	COLLINSHALL(23, false),
	DENNISONHALL(24, false),
	MCBRIDEHALL(25, false),
	DORSEYHALL(26, false),
	OLDMANSE(27, false),
	EVANSSCHOLARSHOUSE(28, false),
	LEWISPLACE(29, false),
	SIMPSONSHADEHOUSE(30, false),
	OGDENHALL(31, false),
	ROUDEBUSHHALL(32, true),
	LAWSHALL(33, true),
	HUGHESHALL(34, true),
	UPHAMHALL(35, true),
	COOKFIELD(36, false),
	COOKPLACE(37, false),
	SHIEDELERHALL(38, true),
	ARMSTRONGSTUDENTCENTER(39, true),
	KREGERHALL(40, true),
	ELLIOTHALL(41, false),
	STODDARDHALL(42, false),
	IRVINHALL(43, false),
	ALUMNIHALL(44, false),
	HARRISONHALL(45, false),
	HALLAUDOTORIUM(46, true),
	KINGLIBRARY(47, true),
	BISHOPHALL(48, true),
	MCGUFFEYHALL(49, true),
	HANNAHOUSE(50, false),
	NELLIECRAIGWALKERHALL(51, false),
	WELLSHALL(52, false),
	JOYNERHOUSE(53, false),
	BONHAMHOUSE(54, false),
	WILLIAMSHALL(55, false),
	MCGUFFEYMUSEUM(56, false),
	WARFIELDHALL(57, false),
	MACMILLANHALL(58, false),
	SESQUICENTENNIALCHAPEL(59, false),
	SHRIVERCENTER(60, true),
	BACHELORHALL(61, true),
	LANGSTROTHCOTTAGE(62, false),
	BEECHWOODSHALL(63, false),
	HILLCRESTHALL(64, false),
	GEOTHERMALENERGYPLANT(65, false),
	STONEBRIDGEHALL(66, false),
	CHILDDEVELOPMENTCENTER(67, false),
	THOMPSONHALL(68, false),
	HAVIGHURSTHALL(69, false),
	CLAWSONHALL(70, false),
	WESTERNDININGCOMMONS(71, false),
	BOYDHALL(72, false),
	BELKGREENHOUSE(73, false),
	MCKEEHALL(74, false),
	HOYTHALL(75, false),
	KUMLERCHAPEL(76, false),
	PEABODYHALL(77, false),
	SAWYERHALL(78, false),
	STEAMPLANT(79, false),
	ERNSTNATURETHEATER(80, false),
	WESTERNLODGE(81, false),
	PHILLIPSHALL(82, false),
	HAMILTONHALL(83, false),
	MINNICHHALL(84, false),
	RICHARDHALL(85, false),
	MACCRACKENHALL(86, false),
	SCOTTHALL(87, false),
	HIESTANDHALL(88, false),
	MAPLESTREETSTATION(89, true),
	CENTERFORPERFORMINGARTS(90, false),
	ARTBUILDING(91, false),
	PATTERSONPLACE(92, false),
	STILLMANKELLYSTUDIO(93, false),
	PRESSERHALL(94, false),
	ETHERIDGEHALL(95, false),
	MORRISHALL(96, false),
	TAPPANHALL(97, false),
	EMERSONHALL(98, false),
	DODDSHALL(99, false),
	STANTONHALL(100, false),
	HARRISHALL(101, false),
	ANDERSONHALL(102, false),
	PORTERHALL(103, false),
	GOGGINICECENTER(104, false),
	CAMPUSAVENUEGARAGE(105, false),
	RECREATIONALSPORTSCENTER(106, false),
	FISHERHALL(107, false),
	LOGANLODGE(108, false),
	BLANCHARDHOUSE(109, false),
	PINESLODGE(110, false),
	HERITAGECOMMONS(111, false),
	TALLAWANDAHALL(112, false),
	REIDHALL(113, false),
	SOUTHCHILLERPLANT(114, false),
	GLOSCENTER(115, false),
	ARTMUSEUM(116, false),
	MURSTEINALUMNICENTER(117, false),
	ADVANCEMENTSERVICES(118, false),
	PEFFERPARK(119, false);
		
	private int id;
	private boolean timeSensitive;
	
	private static Map<Integer, Locations> locationIdMapping = new HashMap<Integer, Locations>();
	
	static {
		for (Locations loc : Locations.values()) {
			locationIdMapping.put(loc.id, loc);
		}
	}
	private Locations(int id, boolean timeSensitive) {
		this.id = id;
		this.timeSensitive = timeSensitive;
	}
	
	public static Locations valueOf(int locationNum) {
		return locationIdMapping.get(locationNum);
	}
	
	public boolean isTimeSensitive() {
		return this.timeSensitive;
	}
}
