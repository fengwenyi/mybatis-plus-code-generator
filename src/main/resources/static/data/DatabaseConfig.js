let dbConfigList = []

function dataDbConfigAdd(key, data) {
    dataDbConfigQueryList()
    if (dbConfigList.length > 4) {
        return false;
    }
    let map = {
        k: key,
        v: data
    }
    dbConfigList.push(map)
    setListDb(dbConfigList)
    return true;
}

function dataDbConfigUpdate(key, data) {
    dataDbConfigQueryList()
    for (let i = 0; i < dbConfigList.length; i++) {
        let map = dbConfigList[i];
        if (map.k === key) {
            map.v = data;
            dbConfigList[i] = map;
            setListDb(dbConfigList)
            return true;
        }
    }
    return false;
}

function dataDbConfigQueryList() {
    dbConfigList = getListDb()
    if (isNull(dbConfigList)) {
        dbConfigList = []
    }
    return dbConfigList;
}

function dataDbConfigQueryByKey(key) {
    dataDbConfigQueryList()
    for (let i = 0; i < dbConfigList.length; i++) {
        if (dbConfigList[i].k === key) {
            return dbConfigList[i];
        }
    }
}

function dataDbConfigCount() {
    dataDbConfigQueryList()
    return dbConfigList.length;
}

function dataDbConfigDelete(key) {
    dataDbConfigQueryList()
    for (let i = 0; i < dbConfigList.length; i++) {
        let map = dbConfigList[i];
        if (map.k === key) {
            dbConfigList.splice(i, 1);
            setListDb(dbConfigList)
            return true;
        }
    }
    return true;
}