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
        let map = list[i]
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

let k1 = '01';
let d1 = {
    name: 'zhangsan',
    age: 16
}
add(k1, d1)
let l = queryList()
console.log(JSON.stringify(l))
let d1_1 = {
    name: 'zhangsan',
    age: 18
}
update(k1, d1_1)
l = queryList()
console.log(JSON.stringify(l))