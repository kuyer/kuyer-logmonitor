package io.github.kuyer.logmonitor.repository;

import io.github.kuyer.logmonitor.entity.DogEntity;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DogMapper {
	
	@Select("select * from dog_entity where name=#{name}")
	public DogEntity findByName(@Param("name") String name);
	
	@Insert("insert into dog_entity (name, age) values (#{name}, #{age})")
	public int insert(@Param("name") String name, @Param("age") Integer age);

}
