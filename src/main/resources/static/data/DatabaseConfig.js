let list = []

function add(key, data) {
    if (list.length > 4) {
        return false;
    }
    let map = {
        k: key,
        v: data
    }
    list.push(map)
    return true;
}

function update(key, data) {
    for (let i = 0; i < list.length; i++) {
        let map = list[i];
        if (map.k === key) {
            map.v = data;
            list[i] = map;
            return true;
        }
    }
    return false;
}

function queryList() {
    return list;
}

function queryByKey(key) {
    for (let i = 0; i < list.length; i++) {
        if (list[i].k === key) {
            return list[i];
        }
    }
}