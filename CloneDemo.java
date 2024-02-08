class CloneDemo implements Cloneable
{
	int  i = 10;
	public static void main(String[] args) throws CloneNotSupportedException
	{
		CloneDemo d = new CloneDemo();
		CloneDemo d1 =(CloneDemo) d.clone();
        Object o1 = new Object();
		Object o2 = o1.clone();
		d.i = 200;
		
		System.out.println(d1.i);
	}
}
