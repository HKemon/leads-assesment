import DS from 'ember-data';

export default DS.RESTSerializer.extend({

    normalizeResponse(store, primaryModelClass, payload, id, requestType) {
        payload = {lists: payload};

        console.log(payload);

        // payload.lists.forEach(
        //
        // );


        return this._super(store, primaryModelClass, payload, id, requestType);
    },
});
