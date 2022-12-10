//Employee.java
package in.nareshit.raghu.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "emptab")
public class Employee implements Serializable {
	@Id
	@GeneratedValue
	@Column(name = "eid")
	private Integer id;
	
	@Column(name = "ename", length = 40)
	private String empName;
	
	@Column(name = "esal")
	private Double empSal;
	
	@Column(name = "edept", length = 40)
	private String empDept;
	
	@Column(name = "eaddr", length = 40)
	private String empAddr;
}
