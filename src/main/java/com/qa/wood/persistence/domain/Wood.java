package com.qa.wood.persistence.domain;

public class Wood {

	private boolean coniferous;

	private String colour;

	private String name;

	private int age;

	private int weight;

	private boolean artificial;

	private boolean soft;

	public Wood() {
		super();
	}

	public Wood(boolean coniferous, String colour, String name, int age, int weight, boolean artificial, boolean soft) {
		super();
		this.coniferous = coniferous;
		this.colour = colour;
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.artificial = artificial;
		this.soft = soft;
	}

	@Override
	public String toString() {
		return "Wood [coniferous=" + coniferous + ", colour=" + colour + ", name=" + name + ", age=" + age + ", weight="
				+ weight + ", artificial=" + artificial + ", soft=" + soft + "]";
	}

	public boolean isConiferous() {
		return coniferous;
	}

	public void setConiferous(boolean coniferous) {
		this.coniferous = coniferous;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public boolean isArtificial() {
		return artificial;
	}

	public void setArtificial(boolean artificial) {
		this.artificial = artificial;
	}

	public boolean isSoft() {
		return soft;
	}

	public void setSoft(boolean soft) {
		this.soft = soft;
	}

}