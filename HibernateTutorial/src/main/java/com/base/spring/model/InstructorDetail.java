package com.base.spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "youtube_channel")
	private String youtubeChannel;

	@Column(name = "hobby")
	private String hobby;

	@Column(name = "deleted")
	private Integer deleted;

	// The following field and its associated getter-setters is only for
	// bi-directional mapping.
	@OneToOne(mappedBy = "instructorDetailId", cascade = CascadeType.ALL)
	private Instructor instructor;

	// The following changes is required if we want to delete the instructorDetail
	// without deleting the instructor.
	// NOTE: Before deleting the instructorDetail in main method set the
	// instructor's instructorDetail to null.
	/*
	 * @OneToOne(mappedBy="instructorDetailId", cascade= {CascadeType.DETACH,
	 * CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}) private
	 * Instructor instructor;
	 */

	public InstructorDetail() {
	}

	public InstructorDetail(String youtubeChannel, String hobby, Integer deleted) {
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
		this.deleted = deleted;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + ", deleted="
				+ deleted + ", instructor=" + instructor.getId() + "]";
	}

}
