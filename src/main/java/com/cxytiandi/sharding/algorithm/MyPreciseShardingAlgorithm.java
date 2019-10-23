package com.cxytiandi.sharding.algorithm;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.util.Collection;
import java.util.Date;

import com.cxytiandi.sharding.util.AlgorithmUtils;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

/**
 * 自定义分片算法
 * 
 * @author yinjihuan
 *
 */
public class MyPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Date> {

	/*@Override
	public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
		for (String tableName : availableTargetNames) {
			if (tableName.endsWith(shardingValue.getValue() % 4 + "")) {
				return tableName;
			}
		}
		throw new IllegalArgumentException();
	}*/

	@Override
	public String doSharding(Collection<String> tableNames, PreciseShardingValue<Date> shardingValue) {
		Date date = shardingValue.getValue();
		Instant instant = Instant.ofEpochMilli(date.getTime());
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
		String userTablePre = "user_";
		for (String each : tableNames) {
			//int year = localDateTime.get(ChronoField.YEAR);

			int month = localDateTime.get(ChronoField.MONTH_OF_YEAR);
			int index = AlgorithmUtils.getTableIndex(month);
			if (each.endsWith(userTablePre + index)) {
				return each;
			}
		}

		throw new UnsupportedOperationException("can't get the table names by sharding value");
	}
}
