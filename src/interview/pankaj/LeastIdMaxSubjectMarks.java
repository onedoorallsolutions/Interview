package interview.pankaj;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class LeastIdMaxSubjectMarks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = {"1,English,30","1,Hindi,40","2,Maths,50","3,English,70","1,Maths,80","2,English,60"};
		HashMap<String,IdMarks> resultMap = new HashMap<>();
		for(int i=0;i<a.length;i++) {
			String data[] = a[i].split(",");
			int studID = Integer.parseInt(data[0]);
			String subject = data[1];
			int marks = Integer.parseInt(data[2]);
			IdMarks im = resultMap.get(subject);
			/*if(im != null) {
				if(im.id > studID) {
					IdMarks updateData = new IdMarks(studID, marks);
					resultMap.put(subject, updateData);
				}
			}
			else {
				IdMarks updateData = new IdMarks(studID, marks);
				resultMap.put(subject, updateData);
			}*/
			//seems to be better than above if else
			if(im != null && im.id < studID) {
				// is there a way fill this something
			}
			else {
				IdMarks updateData = new IdMarks(studID, marks);
				resultMap.put(subject, updateData);
			}
			
		}
		System.out.println("Subject    Marks");
		Iterator<Entry<String, IdMarks>> itr = resultMap.entrySet().iterator();
		while(itr.hasNext()) {
			Entry<String, IdMarks> e = itr.next();
			System.out.println(e.getKey()+"    "+e.getValue().marks);
		}

	}

}
class IdMarks {
	public int id;
	public int marks;
	IdMarks(int id,int marks) {
		this.id = id;
		this.marks = marks;
	}
}
