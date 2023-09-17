const fs = require("fs");

const lines = fs.readFileSync("/etc/trips_sample.json", "utf8").split("\n");
const data = lines.filter(line => line.length > 0).map(line => {
    let response = JSON.parse(line);
    response.start.date = new Date(response.start?.$date)
    response.end.date = new Date(response.end?.$date)
    response.createdAt = new Date(response.createdAt?.$date)
    response.updatedAt = new Date(response.updatedAt?.$date)
    return response
})

db.travels.drop(),
db.travels.createIndex({ country: 1 }),
db.travels.createIndex({ city: 1 }),
db.travels.insertMany(data)
