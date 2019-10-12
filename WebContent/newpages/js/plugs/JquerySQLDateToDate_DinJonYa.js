$.extend({
    SQLDateToDate: function (d) {
        var str = d.replace("/Date(", "");
        var dd = parseInt(str);
        var dt = new Date(dd);
        return dt;
    }
});