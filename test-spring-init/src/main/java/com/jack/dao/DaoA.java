package com.jack.dao;

import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
@DependsOn("autowiredService")
public class DaoA implements IDao {

}
