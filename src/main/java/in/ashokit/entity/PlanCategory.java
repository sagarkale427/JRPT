package in.ashokit.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="PLAN_CATEGORY")
@NoArgsConstructor
@AllArgsConstructor
public class PlanCategory {

	@Id
	@GeneratedValue
	@Column(name="CATEGORY_ID")
	private Integer categoryId;
	
	@Column(name="CATEGORY_NAME")
	private String categoryName;
	
	@Column(name="ACTIVE_SW")
	private String activeSw;
	
	@Column(name="CREATED_DATE",updatable=false)
	@CreationTimestamp
	private LocalDate createdDate;
	
	@Column(name="UPDATE_DATE",insertable=false)
	@UpdateTimestamp
	private LocalDate updateDate;
	
	@Column(name="CREATED_BY")
	private LocalDate createdBy;
	
	@Column(name="UPDATED_BY")
	private LocalDate updatedBy;

	
	
	
	
}
