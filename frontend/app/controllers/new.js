import Controller from '@ember/controller';

export default Controller.extend({
    actions: {
        newStudent: function () {
            let name = this.get("name");
            let address = this.get("address");
            let dateOfBirth = this.get("dob");

            console.log(dateOfBirth);

            let newStudent = this.store.createRecord('new', {
                name: name,
                address: address,
                dateOfBirth: new Date(dateOfBirth).toDateString()
            });

            newStudent.save();

            this.setProperties({
                name: '',
                address: '',
                dateOfBirth: ''
            });

            console.log(name + ' ' + address + ' ' + dateOfBirth);
        }
    }
});
