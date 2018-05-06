package Hello;

import java.util.*;

public class javaCollection {
	private List addressList;
	private Set addressSet;
	private Map addressMap;
	private Properties addressProp;
	
	public void setaddressList(List list) {
		this.addressList = list;
	}
	
	public List getaddressList(){
		System.out.println("addressList is getting now: " + addressList);
		return this.addressList;
	}
	/////////////////////////////////////////
	public void setaddressSet(Set set) {
		this.addressSet = set;
	}
	
	public Set getaddressSet(){
		System.out.println("addressSet is getting now: " + addressSet);
		return this.addressSet;
	}
	////////////////////////////////////////
	public void setaddressMap(Map map) {
		this.addressMap = map;
	}
	
	public Map getaddressMap(){
		System.out.println("addressMap is getting now: " + addressMap);
		return this.addressMap;
	}
	////////////////////////////////////////
	public void setaddressProp(Properties prop) {
		this.addressProp = prop;
	}
	
	public Properties getaddressProp(){
		System.out.println("addressProp is getting now: " + addressProp);
		return this.addressProp;
	}
}
