package pl.edu.pw.mini.zpoif.lab1.local;

import java.util.Objects;

public class Person {
	private Integer id;
	private String name;
	private String lastName;
	private Integer age;
	private boolean male;

	public Person(Integer id, String name, String lastName, Integer age, boolean male) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.male = male;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public Integer getAge() {
		return age;
	}

	public boolean isMale() {
		return male;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", lastName=" + lastName + ", age=" + age + ", male=" + male
				+ "]";
	}

}
