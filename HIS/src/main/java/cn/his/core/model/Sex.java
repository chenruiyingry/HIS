package cn.his.core.model;

public enum Sex {

	MAN{
		public String getName(){return "男";}
	},
	WOMAN{
		public String getName(){return "女";}
	};
	
	public abstract String getName();

}
