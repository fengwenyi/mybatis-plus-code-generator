let dbConfigList = []

function dataDbConfigAdd(key, data) {
    if (dbConfigList.length > 4) {
        return false;
    }
    let map = {
        k: key,
        v: data
    }
    dbConfigList.push(map)
    return true;
}

function dataDbConfigUpdate(key, data) {
    for (let i = 0; i < dbConfigList.length; i++) {
        let map = dbConfigList[i];
        if (map.k === key) {
            map.v = data;
            dbConfigList[i] = map;
            return true;
        }
    }
    return false;
}

function dataDbConfigQueryList() {
    return dbConfigList;
}

function dataDbConfigQueryByKey(key) {
    for (let i = 0; i < dbConfigList.length; i++) {
        if (dbConfigList[i].k === key) {
            return dbConfigList[i];
        }
    }
}

function dataDbConfigCount() {
    return dbConfigList.length;
}

function dataDbConfigDelete(key) {
    for (let i = 0; i < dbConfigList.length; i++) {
        let map = dbConfigList[i];
        if (map.k === key) {
            dbConfigList.splice(i, 1);
            return true;
        }
    }
    return true;
}