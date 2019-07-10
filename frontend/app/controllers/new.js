import Controller from '@ember/controller';

export default Controller.extend({
    actions: {
        newStudent: function () {
            let name = this.get("name");
            let address = this.get("address");
            let dob = this.get("dob");
            console.log(name);
            alert(name);
        }
    }
});
