package com.fifi.java.practise.springhibernate.obj;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Comment {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "POSTID")
	private Long postId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "BODY", columnDefinition="CLOB")
	private String body;
	
	public Comment() {
		super();
	}

	public Comment(Long id, Long postId, String name, String email, String body) {
		super();
		this.id = id;
		this.postId = postId;
		this.name = name;
		this.email = email;
		this.body = body;
	}

	public Comment(Long postId, String name, String email, String body) {
		super();
		this.postId = postId;
		this.name = name;
		this.email = email;
		this.body = body;
	}	
	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", postId=" + postId + ", name=" + name + ", email=" + email + ", body=" + body
				+ "]";
	}

	
	//ignore ID as it is auto-increment
	@Override  
	public boolean equals(Object obj)   
	{  
		if (obj == null)   
		return false;  
 
		if (obj.getClass() == this.getClass())	{
			
			Comment commentObj = (Comment) obj;
			
			if (this.getBody().equals(commentObj.getBody()) && 
				this.getEmail().equals(commentObj.getEmail()) &&
				this.getName().equals(commentObj.getName()) &&
				this.getPostId().longValue() == commentObj.getPostId().longValue())	{
				return true;								
			}
		}
		return false;
	}  

}


