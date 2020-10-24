const pg = require( "pg");
const sinon = require('sinon');
const expect = require( "chai").expect;

describe("Service tests", () => {
    afterEach(() => {
      sinon.restore();
    });
    it("should get all the cars", async () => {
      const mPool = { query: sinon.stub().resolves({ rows: [
        {
            "id": "0186758a-f1fd-43ef-aca5-68d1b9908379",
            "active": true,
            "added": "2020-10-23T14:41:45.902Z",
            "brand": "Toyota",
            "image": null,
            "model": "Corolla",
            "reg_plate": "HHH-111"
            },
            {
            "id": "bfce4ac3-e1bf-465b-b179-e53528747f45",
            "active": true,
            "added": "2020-10-23T16:46:05.939Z",
            "brand": "Ford",
            "image": null,
            "model": "Mustang",
            "reg_plate": "HHH-123"
            }
      ] }) };
      const poolStub = sinon.stub(pg, "Pool").callsFake(() => mPool);
      const service = require("../services/car.sevice");
      const actual = await service.getCars();
      expect(actual.rows.length).to.equal(2);
      sinon.assert.calledOnce(poolStub);
      sinon.assert.calledOnce(mPool.query);
    });
  });