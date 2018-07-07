package loging;

public class User {
	String username, name, password;
	long lastActive;
	boolean isActive;
	Integer requestCount=1, invalidRequestCount=0;
	
	public void setUsername(String s){
		username=s;
	}
	public void setName(String s){
		name=s;
	}
	public void setPassword(String s){
		password=s;
	}
	public String getUsername(){
		return username;
	}
	public String getName(){
		return name;
	}
	public String getPassword(){
		return password;
	}
	public String toString(){
		return name;
	}
	public long getLastActive(){
		return lastActive;
	}
	public void setLastActive(long t){
		lastActive=t;
	}
	public void setIsActive(boolean b){
		isActive=b;
	}
	public boolean getIsActive(){
		return isActive;
	}
	public boolean equals(User u){
		if(u.getUsername() == username){
			return true;
		}
		else return false;
	}
	public int compareTo(User u){
		return username.compareTo(u.username);
	}
	public Integer getRequestCount(){
		return requestCount;
	}
	public Integer oneMoreRequest(){
		return requestCount++;
	}
	public Integer getInvalidRequestCount(){
		return invalidRequestCount;
	}
	public Integer oneMoreInvalidRequest(){
		return invalidRequestCount++;
	}
}
