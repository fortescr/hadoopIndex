package br.com.java.hadoop;

import java.io.IOException;
import java.util.HashMap;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Reduce extends Reducer<Text, Text, Text, Text> {
	@Override
	public void reduce(Text key, Iterable<Text> values, Context context)
			throws IOException, InterruptedException {
		HashMap m=new HashMap();
		int count=0;
		for(Text t:values){
			String str=t.toString();
			if(m!=null &&m.get(str)!=null){
				count=(int)m.get(str);
				m.put(str, ++count);
			}else{
				m.put(str, 1);
			}
		}
		context.write(key, new Text(m.toString()));
	}

}
