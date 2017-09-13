import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dbutil.SessionFactory;

public class Sample
{
	public void sample1()
	{
		System.out.println("......简单条件查询.........");
		SqlSession session = SessionFactory.getFactory().openSession();
		Program p = (Program) session.selectOne("selprogram", 1);

		System.out.println(p.getProgramName());
		session.close();
		System.out.println("..........测试成功............");
	}
	
	public void sample2()
	{
		System.out.println("......手动构建sql语句进行查询...........");
		SqlSession session = SessionFactory.getFactory().openSession();
		String sql = new SQL()
		{
			{
				SELECT("*");
				FROM("sweet_program");
			}
		}.toString();
		System.out.println(sql);
		List<Map<String, Object>> list = session.selectList("selectAll",sql);
		for (int i = 0; i < list.size(); i++)
		{
			Map m = list.get(i);
			Iterator it = m.keySet().iterator();
			while (it.hasNext())
			{
				String key = it.next().toString();
				System.out.println(key + ":" + m.get(key));
			}
		}
		session.close();
		System.out.println("..........测试成功............");
	}
	public void sample3()
	{
		System.out.println("......多条件查询.........");
		SqlSession session = SessionFactory.getFactory().openSession();
		Map map=new HashMap();
		map.put("id", 1);
		map.put("parent", 2);
		Program p1 = (Program) session.selectOne("selMutil", map);
		System.out.println(p1.getProgramName());
		session.close();
		System.out.println("..........测试成功............");
	}
	
	public void sample4()
	{
		System.out.println(".......插入数据...........");
		SqlSession session = SessionFactory.getFactory().openSession();
		Map map=new HashMap();
		map.put("programName", "右侧");
		map.put("parent", 2);
		
		int i= session.insert("insertProgram", map);
		session.commit();
		session.close();
		System.out.println("........测试成功............");
	}
	
	public void sample5()
	{
		System.out.println(".......更新数据...........");
		SqlSession session = SessionFactory.getFactory().openSession();
		Map map=new HashMap();
		map.put("programName", "右侧附表");
		map.put("id", 7);
		
		int i= session.update("updateProgram", map);
		session.commit();
		session.close();
		System.out.println("........测试成功............");
	}
	public void sample6()
	{
		System.out.println(".......删除数据...........");
		SqlSession session = SessionFactory.getFactory().openSession();
		Map map=new HashMap();
		map.put("id", 7);
		
		int i= session.delete("deleteProgram", map);
		session.commit();
		session.close();
		System.out.println("........测试成功............");
	}
	public static void main(String [] args)
	{
		Sample sample=new Sample();
		sample.sample1();
		sample.sample2();
		sample.sample3();
//		sample.sample4();
//		sample.sample5();
//		sample.sample6();
	}
}
