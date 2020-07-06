package com.lagou.homework1;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class SortReducer extends Reducer<LongWritable, LongWritable, LongWritable, LongWritable> {
    private static LongWritable sum = new LongWritable(1);

    @Override
    protected void reduce(LongWritable key, Iterable<LongWritable> values, Context context)
            throws IOException, InterruptedException {
        for (LongWritable value : values) {
            context.write(sum, key);
            sum = new LongWritable(sum.get() + 1);
        }
    }
}
