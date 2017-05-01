######################################
# Redis Cluster Ready
mkdir -p work
cd work

WORK_HOME=`pwd`

wget "http://download.redis.io/releases/redis-3.2.8.tar.gz"
tar xvzf redis-3.2.8.tar.gz

cd redis-3.2.8
REDIS_HOME=`pwd`
make

cd utils/create-cluster
CLUSTER_CMD_HOME=`pwd`

cd $CLUSTER_CMD_HOME
./create-cluster start
./create-cluster create
yes



