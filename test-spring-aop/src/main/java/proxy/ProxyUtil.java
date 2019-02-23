package proxy;

import dao.UserDao;
import dao.UserDaoImpl;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class ProxyUtil {

	/**
	 * 构建动态代理对象的方法
	 * @param target 目标对象
	 * @return
	 */
	public static Object newInstance(Object target) {
		Object proxy = null;
		Class targetInterface = target.getClass().getInterfaces()[0];
		String content = "";
		String simpleName = targetInterface.getSimpleName();
		Method[] methods = targetInterface.getMethods();
		String line = "\n";
		String tab = "\t";
		String packageContent = "package com.jack.proxy;" + line;
		String importContent = "import " + targetInterface.getName() +";"+line;
		String clazzFirstContent = "public class $Proxy implements " + simpleName + "{" + line;
		String fieldContent = tab + "private " + simpleName + " target;" + line;
		// 构造方法
		String construceContent = tab + "public $Proxy ("+simpleName+" target) {" + line
				+ tab + tab + "this.target = target;" + line + tab + "}" + line;
		String methodContent = "";
		for (Method method : methods) {
			String methodName = method.getName();
			String argsContent = "";
			String paramterContent = "";
			Class<?>[] parameterTypes = method.getParameterTypes();
			// String c0,String c1

			int flag = 0;
			for (Class<?> parameterType : parameterTypes) {
				argsContent += parameterType.getName() + " c" + flag +",";
				paramterContent += " c" + flag +",";
				flag ++;
			}
			if (argsContent.length() > 0) {
				argsContent = argsContent.substring(0, argsContent.length()-1);
				paramterContent = paramterContent.substring(0, paramterContent.length() - 1);
			}

			methodContent += tab + "public " + method.getReturnType().getSimpleName() +" "+ methodName + "(" + argsContent + ") {" + line
					+ tab + tab + "System.out.println(\"此处切入点记录日志\");" + line;


			if (!method.getReturnType().getSimpleName().equals("void")) {
				methodContent += tab + tab + "return target." + methodName + "("+paramterContent+");" + line + tab + "}" + line;
			}else {
				methodContent += tab + tab + "target." + methodName + "("+paramterContent+");" + line + tab + "}" + line;
			}


		}
		content = packageContent + importContent + clazzFirstContent + fieldContent + construceContent + methodContent + line + "}";
		File file = null;
		try {
			file = new File("d:\\com\\jack\\proxy\\$Proxy.java");
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file);
			fw.write(content);
			fw.flush();
			fw.close();

			JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
			StandardJavaFileManager standardFileManager = javaCompiler.getStandardFileManager(null, null, null);
			Iterable<? extends JavaFileObject> javaFileObjects = standardFileManager.getJavaFileObjects(file);
			JavaCompiler.CompilationTask task = javaCompiler.getTask(null, standardFileManager, null, null, null, javaFileObjects);
			task.call();
			standardFileManager.close();
			URL[] urls = new URL[]{new URL("file:d:\\\\")};
			URLClassLoader classLoader = new URLClassLoader(urls);
			Class<?> aClass = classLoader.loadClass("com.jack.proxy.$Proxy");
			Constructor<?> constructor = aClass.getConstructor(targetInterface);//只要确定构造方法参数的类型即可
			proxy = constructor.newInstance(target);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return proxy;
	}

	public static void main(String[] args) {
		UserDao proxy = (UserDao) ProxyUtil.newInstance(new UserDaoImpl());
		String returnstr = proxy.query("aaa", 10);
		System.out.println("方法返回结果为： " + returnstr);
	}
}
