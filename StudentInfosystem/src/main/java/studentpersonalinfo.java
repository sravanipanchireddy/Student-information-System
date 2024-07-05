
public class studentpersonalinfo {
		private String jntuno,name,fname,mname,address,phone,email,gender,dateofbirth,password,college,branch,year,semester,cgpa;

		
		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getMname() {
			return mname;
		}

		public void setMname(String mname) {
			this.mname = mname;
		}

		public String getDateofbirth() {
			return dateofbirth;
		}

		public void setDateofbirth(String dateofbirth) {
			this.dateofbirth = dateofbirth;
		}

		public String getBranch() {
			return branch;
		}

		public void setBranch(String branch) {
			this.branch = branch;
		}

		public String getCollege() {
			return college;
		}

		public void setCollege(String college) {
			this.college = college;
		}

		public String getSemester() {
			return semester;
		}

		public void setSemester(String semester) {
			this.semester = semester;
		}

		public String getJntuno() {
			return jntuno;
		}

		public void setJntuno(String jntuno) {
			this.jntuno = jntuno;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getFname() {
			return fname;
		}

		public void setFname(String fname) {
			this.fname = fname;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCgpa() {
			return cgpa;
		}

		public void setCgpa(String cgpa) {
			this.cgpa = cgpa;
		}

		public String getYear() {
			return year;
		}

		public void setYear(String year) {
			this.year = year;
		}
		public studentpersonalinfo(String jntuno, String name, String fname, String mname,String address,String phone,String email,String gender,String dateofbirth,String password,String college,String branch,String year,String semester,String cgpa) {
			super();
			this.jntuno = jntuno;
			this.password = password;
			this.email = email;
			this.mname = mname;
			this.fname = fname;
			this.email = email;
			this.gender = gender;
			this.dateofbirth = dateofbirth;
			this.college = college;
			this.branch = branch;
			this.year = year;
			this.semester = semester;
			this.cgpa = cgpa;
			this.name = name;
			this.phone = phone;
		}


		public studentpersonalinfo() {
			super();
		}
		

	}



