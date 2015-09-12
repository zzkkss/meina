package com.gw.listener;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public  class StaticProperty {
/**
 * 声明一个全局变量，用来运行线程。
 */
public static ExecutorService exec=Executors.newCachedThreadPool();
public static String Url="";
////终端列表
//public static Vector<Terminals> terminalList=new Vector<Terminals>();
////基站列表
//public static Vector<Stations> stationsList=new Vector<Stations>();

//public static Connection mysqlcon=null;
//public static Session session=null;

}
