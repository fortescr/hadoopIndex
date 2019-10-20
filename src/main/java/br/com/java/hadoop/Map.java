package br.com.java.hadoop;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

public class Map extends Mapper<LongWritable,Text,Text,Text> {

	@Override
	public void map(LongWritable key, Text value, Context context)
			throws IOException,InterruptedException
	{

		String fileName = ((FileSplit) context.getInputSplit()).getPath().getName();

		String line=value.toString().replaceAll("[^a-zA-Z0-9]", " ");

		String words[]=line.split(" ");
		for(String s:words){
			
			context.write(new Text(s), new Text(fileName));
		}
	}
}
	