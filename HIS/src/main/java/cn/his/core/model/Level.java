package cn.his.core.model;

public enum Level {
	
	FELDSHER{
		public String getName() {return "医士";}
	},
	PHYSICIAN{
		public String getName() {return "医师";}
	},
	RESIDENT{
		public String getName() {return "住院医师";}
	},
	ATTENDING{
		public String getName() {return "主治医师";}
	},
	ASSOCIATECHIEF{
		public String getName() {return "副主任医师";}
	},
	CHIEF{
		public String getName() {return "主任医师";}
	};
	public abstract String getName();
}
