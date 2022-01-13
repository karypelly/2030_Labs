

/* 
 * READ THE PDF INSTRUCTION BEFORE GETTING STARTED!
 * Your Tasks: Override 'equals' and 'compareTo' methods of this class.
 */

public class EmployeeInfo implements Comparable<EmployeeInfo> {
	private String name;
	private double salary;
	private Integer departmentId;
	
	/** 
	 * @param name the name to set 
	 * @param salary to salary to set
	 * @param departmentId to departmentId to set
	 */
	public EmployeeInfo(String name, double salary, Integer departmentId) {
		this.name = name; 
		this.salary = salary;
		this.departmentId = departmentId;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}
	
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	/**
	 * @return the departmentId
	 */
	public Integer getDepartmentId() {
		return departmentId;
	}
	
	/**
	 * @param departmentId the departmentId to set
	 */
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}	
	
	
	
	/**
	 * Compare this EmployeeInfo object and other EmployeeInfo object.
	 * 
	 * An EmployeeInfo 'info1' is "smaller" than another 'info2' if
	 * info1's salary is higher than info2's. If both have the same
	 * salary, then one with a larger department id is considered as "smaller".
	 * 
	 * When being sorted in an increasing order (using Arrays.sort), 
	 * the smaller EmployeeInfo object appears earlier than the larger one.
	 *  
	 * @return Positive value if this is larger than other, 
	 * 			negative if this is smaller than other,
	 * 			zero otherwise.
	 */
	public int compareTo(EmployeeInfo other) {
		/* Your Task */
		if (this.getSalary() > other.getSalary()) {
			return -1;
		}else if (this.getSalary() < other.getSalary()) {
			return 1;
		}else if (this.getSalary() == other.getSalary()) {
			if (this.getDepartmentId() > other.getDepartmentId()) {
				return -1;
			}else if (this.getDepartmentId() < other.getDepartmentId()) {
				return 1;
			}else if (this.getDepartmentId() == other.getDepartmentId()) {
				return 0;
			}
		}
		return 0;
	}

	/**
	 * Two EmployeeInfo objects are equal if their name, salary, and
	 * department id are equal.
	 * 
	 * @return Whether this EmployeeInfo object equals 'obj'
	 */
	@Override
	public boolean equals(Object obj) {
		/* Your Task */
		if (this == obj) {
			return true;
		}else if (obj == null) {
			return false;
		}else if (this.getClass() != obj.getClass()) {
			return false;
		}
		EmployeeInfo other = (EmployeeInfo) obj;
		if (this.name == other.name && this.salary == other.salary && this.departmentId == other.departmentId) {
			return true;
		}
		return false;
	}
}
