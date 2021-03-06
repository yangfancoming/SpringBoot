package com.goat.fastjson.entity;

import com.alibaba.fastjson.annotation.JSONType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true) // 将这个注解写在类上之后，就会忽略类中不存在的字段。这个注解还可以指定要忽略的字段 eg：@JsonIgnoreProperties({ "temp1", "temp2" })
//@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
//@JsonSerialize(using = UserSerializer.class)
//@JsonDeserialize(using = UserDeserializer.class)

/**
 //配置序列化的时候,不序列化id  sex
 @JSONType(ignores ={"id", "sex"})

 // 配置序列化的时候,序列化name 和sex
 @JSONType(includes={"name","sex"})
 */
@JSONType(ignores ={"id", "sex"})
public class TestUser implements Serializable {

	private static final long serialVersionUID = 6222176558369919436L;

	public interface UserNameView {
	}

	public interface AllUserFieldView extends UserNameView {
	}

	@JsonView(UserNameView.class)
	private String userName;
	
	@JsonView(AllUserFieldView.class)
	private int age;

	@JsonView(AllUserFieldView.class)
	private String password;

	// @JsonProperty("bth")
	 @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonView(AllUserFieldView.class)
	private Date birthday;


    private String temp1;

    private String temp2;

    @JsonIgnore //作用是json序列化时将java bean中的一些属性忽略掉,序列化和反序列化都受影响。
    private String temp3;

    private String temp4;




	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

    public String getTemp1() {
        return temp1;
    }

    public void setTemp1(String temp1) {
        this.temp1 = temp1;
    }

    public String getTemp2() {
        return temp2;
    }

    public void setTemp2(String temp2) {
        this.temp2 = temp2;
    }

    public String getTemp3() {
        return temp3;
    }

    public void setTemp3(String temp3) {
        this.temp3 = temp3;
    }

    public String getTemp4() {
        return temp4;
    }

    public void setTemp4(String temp4) {
        this.temp4 = temp4;
    }
}
