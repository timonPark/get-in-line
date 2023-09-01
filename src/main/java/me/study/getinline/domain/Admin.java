package me.study.getinline.domain;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Admin {
	private Long id;

	private String email;
	private String nickname;
	private String password;
	private String phoneNumber;
	private String name;

	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
}
