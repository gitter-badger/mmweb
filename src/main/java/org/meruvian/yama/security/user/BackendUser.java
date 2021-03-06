/**
 * Copyright 2012 BlueOxygen Technology
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0 
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.meruvian.yama.security.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.meruvian.yama.persistence.DefaultPersistence;

/**
 * @author Dian Aditya
 * 
 */
@Entity
@Table(name = "mik_backend_user")
public class BackendUser extends DefaultPersistence {
	private String username;
	private String password;
	private String email;
	private String role;
	private String fbasccesstoken;
	private long fbexpiredate;
	
	@Column(unique = true)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFbasccesstoken() {
		return fbasccesstoken;
	}

	public void setFbasccesstoken(String fbasccesstoken) {
		this.fbasccesstoken = fbasccesstoken;
	}

	public long getFbexpiredate() {
		return fbexpiredate;
	}

	public void setFbexpiredate(long fbexpiredate) {
		this.fbexpiredate = fbexpiredate;
	}

}
