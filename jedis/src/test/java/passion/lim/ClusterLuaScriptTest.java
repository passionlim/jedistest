package passion.lim;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class ClusterLuaScriptTest {

	private String host = "127.0.0.1";
	int port = 30001;

	private JedisCluster jedisCluster;
	private RedisClusterUtils redisClusterUtils;

	@Before
	public void jedisCluster() {
		List<HostAndPort> nodes = new ArrayList<>();
		nodes.add(new HostAndPort(host, port + 0));

		this.jedisCluster = new JedisCluster(new HashSet<>(nodes));

		redisClusterUtils = new RedisClusterUtils(jedisCluster, "test:");
	}

	@Test
	public void testClear() {
		redisClusterUtils.clear();

	}
}
