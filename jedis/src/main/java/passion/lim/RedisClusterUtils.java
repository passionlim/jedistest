package passion.lim;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

public class RedisClusterUtils {
	public static String CLEAR_LUA_SCRIPT = "local keys = redis.call('KEYS', ARGV[1]); local keysCount = table.getn(keys); if(keysCount > 0) then for _, key in ipairs(keys) do redis.call('del', key); end; end; return keysCount;";
	
	private String prefix;
	private JedisCluster jedisCluster;

	public RedisClusterUtils(JedisCluster jedisCluster, String prefix) {
		this.jedisCluster = jedisCluster;
		this.prefix = prefix;
		
	}
	
	public void clear() {
		jedisCluster.eval(CLEAR_LUA_SCRIPT, Collections.emptyList(), Arrays.asList(prefix + "*"));
	}

}
