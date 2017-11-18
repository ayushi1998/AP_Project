package classes;

import java.io.Serializable;
/**
 * 
 * @author Tanish And Ayushi
 *
 */
public class Course implements Serializable{
	
	
	
		/**
	 * 
	 */
	private static final long serialVersionUID = -99410940401151391L;
		private String coption; // Mandatory / Elective
		private String cname;
		private String ccode;
		private String instr;
		private String credits;
		String acro;
		private String mon_slot;
		private String tue_slot;
		private String wed_slot;
		private String thu_slot;
		private String fri_slot;
		private String tut_slot;
		private String lab_slot;
		String precond;
		private String[] keywords;
		private String postcond;
		/**
		 * 
		 * @param a type of course
		 * @param b name of the course
		 * @param c code of the course
		 * @param d instructor for the course
		 * @param e credits
		 * @param f short form 
		 * @param g classes on monday
		 * @param h classes on tuesday
		 * @param i classes on wednesday
		 * @param j classes on thursda
		 * @param k classes on fri
		 * @param l tut slots
		 * @param m lab slots
		 * @param n precondition
		 * @param o postconditions 
		 */
		public Course(String a, String b, String c, String d, String e, String f, String g, String h, String i, String j,
				String k, String l, String m, String n, String o) {
			setCoption(a);
			setCname(b);
			setCcode(c);
			setInstr(d);
			setCredits(e);
			acro = f;
			setMon_slot(g);
			setTue_slot(h);
			setWed_slot(i);
			setThu_slot(j);
			setFri_slot(k);
			setTut_slot(l);
			setLab_slot(m);
			precond = n;
			setPostcond(o);
			setKeywords(postcond.split(" "));
			
		}

		/**
		 * 
		 * @return name 
		 */
		public String getCname() {
			return cname;
		}

		/**
		 * 
		 * @param cname course name
		 */
		public void setCname(String cname) {
			this.cname = cname;
		}

		/**
		 * 
		 * @return post condition
		 */
		public String getPostcond() {
			return postcond;
		}

		/**
		 * 
		 * @param postcond sets post conditions
		 */
		public void setPostcond(String postcond) {
			this.postcond = postcond;
		}

		/**
		 * @return the keywords
		 */
		public String[] getKeywords() {
			return keywords;
		}

		/**
		 * @param keywords the keywords to set
		 */
		public void setKeywords(String[] keywords) {
			this.keywords = keywords;
		}

		/**
		 * @return the coption
		 */
		public String getCoption() {
			return coption;
		}

		/**
		 * @param coption the coption to set
		 */
		public void setCoption(String coption) {
			this.coption = coption;
		}

		/**
		 * @return the credits
		 */
		public String getCredits() {
			return credits;
		}

		/**
		 * @param credits the credits to set
		 */
		public void setCredits(String credits) {
			this.credits = credits;
		}

		/**
		 * @return the mon_slot
		 */
		public String getMon_slot() {
			return mon_slot;
		}

		/**
		 * @param mon_slot the mon_slot to set
		 */
		public void setMon_slot(String mon_slot) {
			this.mon_slot = mon_slot;
		}

		/**
		 * @return the tue_slot
		 */
		public String getTue_slot() {
			return tue_slot;
		}

		/**
		 * @param tue_slot the tue_slot to set
		 */
		public void setTue_slot(String tue_slot) {
			this.tue_slot = tue_slot;
		}

		/**
		 * @return the wed_slot
		 */
		public String getWed_slot() {
			return wed_slot;
		}

		/**
		 * @param wed_slot the wed_slot to set
		 */
		public void setWed_slot(String wed_slot) {
			this.wed_slot = wed_slot;
		}

		/**
		 * @return the thu_slot
		 */
		public String getThu_slot() {
			return thu_slot;
		}

		/**
		 * @param thu_slot the thu_slot to set
		 */
		public void setThu_slot(String thu_slot) {
			this.thu_slot = thu_slot;
		}

		/**
		 * @return the fri_slot
		 */
		public String getFri_slot() {
			return fri_slot;
		}

		/**
		 * @param fri_slot the fri_slot to set
		 */
		public void setFri_slot(String fri_slot) {
			this.fri_slot = fri_slot;
		}

		/**
		 * @return the tut_slot
		 */
		public String getTut_slot() {
			return tut_slot;
		}

		/**
		 * @param tut_slot the tut_slot to set
		 */
		public void setTut_slot(String tut_slot) {
			this.tut_slot = tut_slot;
		}

		/**
		 * @return the lab_slot
		 */
		public String getLab_slot() {
			return lab_slot;
		}

		/**
		 * @param lab_slot the lab_slot to set
		 */
		public void setLab_slot(String lab_slot) {
			this.lab_slot = lab_slot;
		}

		/**
		 * @return the instr
		 */
		public String getInstr() {
			return instr;
		}

		/**
		 * @param instr the instr to set
		 */
		public void setInstr(String instr) {
			this.instr = instr;
		}

		/**
		 * @return the ccode
		 */
		public String getCcode() {
			return ccode;
		}

		/**
		 * @param ccode the ccode to set
		 */
		public void setCcode(String ccode) {
			this.ccode = ccode;
		}

	
}
