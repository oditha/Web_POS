//Startup

$(document).ready(function () {

    loadWidgets();
    loadPieChart();
    userViseWorks();
    userViseWorksGsandaru()
    userViseWorksDILL();
    userViseWorksODK();
    userViseWorksSL();
})

// load widgets

function loadWidgets() {

    $.ajax({

        method: "POST",
        url: "loadWidgets",
        success: function (responseText) {

            var json = JSON.parse(responseText);

            $("#gsandaru").text(json.Fiverr_GSANDARU);
            $("#dill").text(json.Fiverr_DILL);
            $("#odk").text(json.Fiverr_ODK);
            $("#upworks").text(parseInt(json.Upwork) + parseInt(json.Sri_Lanka));


        }

    })

}


// pie chart

function loadPieChart() {

    $.ajax({

        method: "post",
        url: "loadAccVise",
        success: function (response) {

            var acc = [];
            var count = [];

            data = response.trim();
            data = JSON.parse(response);

            for (var i in data) {
                acc.push(data[i].acc);
                count.push(data[i].count);

            }

            var chartdata = {
                labels: acc,
                datasets: [
                    {
                        backgroundColor: ["rgb(39,174,96, 0.7)", "rgb(41,128,185, 0.7)", "rgb(142,68,173, 0.7)", "rgb(192,57,43, 0.7)", "rgb(44,62,80,0.7)"],

                        data: count
                    }
                ]
            };

            var ctx = document.getElementById("accountvise").getContext('2d');


            var myPieChart = new Chart(ctx, {
                type: 'doughnut',
                data: chartdata,

            });

        }


    });

}

// acc vise users

function userViseWorks() {


    $.ajax({

        method: "post",
        url: "userViseBarChart",
        success: function (response) {

            var user = [];
            var count = [];
            var updates = [];
            data = response.trim();
            data = JSON.parse(response);

            for (var i in data) {
                user.push(data[i].user);
                count.push(data[i].count);
                updates.push(data[i].update);
            }

            var chartdata = {
                labels: user,
                datasets: [
                    {
                        label: 'New Works',
                        backgroundColor: 'rgba(54, 162, 235, 0.5)',
                        borderColor: 'rgba(200, 200, 200, 0.1)',
                        hoverBackgroundColor: 'rgba(153, 102, 255, 0.5)',
                        hoverBorderColor: 'rgba(200, 200, 200, 1)',
                        data: count,
                        yAxisID: 'y-axis-1',
                    },
                    {
                        label: 'Updates',
                        backgroundColor: 'rgba(20, 200, 235, 0.5)',
                        borderColor: 'rgba(200, 200, 200, 0.1)',
                        hoverBackgroundColor: 'rgba(39,174,96, 0.5)',
                        hoverBorderColor: 'rgba(200, 200, 200, 1)',
                        data: updates,
                        yAxisID: 'y-axis-2',
                    },
                ]
            };

            var ctx = document.getElementById("uservise").getContext('2d');
            var myChart = new Chart(ctx, {
                type: 'bar',
                data: chartdata,
                options: {
                    scales: {
                        yAxes: [{
                            type: 'linear', // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
                            display: true,
                            position: 'left',
                            id: 'y-axis-1',
                        }, {
                            type: 'linear', // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
                            display: true,
                            position: 'right',
                            id: 'y-axis-2',
                            // gridLines: {
                            //     drawOnChartArea: false
                            // }
                        }],
                    }
                }
            });

        }

    });


}

function userViseWorksGsandaru() {


    $.ajax({

        method: "post",
        url: "userViseBarChartSandaru",
        success: function (response) {

            var user = [];
            var count = [];
            var updates = [];
            data = response.trim();
            data = JSON.parse(response);

            for (var i in data) {
                user.push(data[i].user);
                count.push(data[i].count);
                updates.push(data[i].update);
            }

            var chartdata = {
                labels: user,
                datasets: [
                    {
                        label: 'New Works',
                        backgroundColor: 'rgba(54, 162, 235)',
                        borderColor: 'rgba(4, 162, 235)',
                        fill: false,
                        data: count,
                        yAxisID: 'y-axis-1',
                    },
                    {
                        label: 'Updates',
                        backgroundColor: 'rgba(142,68,173)',
                        borderColor: 'rgba(142,68,173)',
                        fill: false,
                        data: updates,
                        yAxisID: 'y-axis-2',
                    },
                ]
            };

            var ctx = document.getElementById("sandaruacc").getContext('2d');
            var myChart = new Chart(ctx, {
                type: 'line',
                data: chartdata,
                options: {
                    responsive: true,
                    hoverMode: 'index',
                    stacked: false,
                    scales: {
                        yAxes: [{
                            type: 'linear', // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
                            display: true,
                            position: 'left',
                            id: 'y-axis-1',
                        }, {
                            type: 'linear', // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
                            display: true,
                            position: 'right',
                            id: 'y-axis-2',
                            // gridLines: {
                            //     drawOnChartArea: false
                            // }
                        }],
                    }
                }
            });

        }

    });


}

function userViseWorksDILL() {


    $.ajax({

        method: "post",
        url: "userViseBarChartDILL",
        success: function (response) {


            var user = [];
            var count = [];
            var updates = [];
            data = response.trim();
            data = JSON.parse(response);

            for (var i in data) {
                user.push(data[i].user);
                count.push(data[i].count);
                updates.push(data[i].update);
            }

            var chartdata = {
                labels: user,
                datasets: [
                    {
                        label: 'New Works',
                        backgroundColor: 'rgba(54, 162, 235)',
                        borderColor: 'rgba(4, 162, 235)',
                        fill: false,
                        data: count,
                        yAxisID: 'y-axis-1',
                    },
                    {
                        label: 'Updates',
                        backgroundColor: 'rgba(142,68,173)',
                        borderColor: 'rgba(142,68,173)',
                        fill: false,
                        data: updates,
                        yAxisID: 'y-axis-2',
                    },
                ]
            };

            var ctx = document.getElementById("dillacc").getContext('2d');
            var myChart = new Chart(ctx, {
                type: 'line',
                data: chartdata,
                options: {
                    responsive: true,
                    hoverMode: 'index',
                    stacked: false,
                    scales: {
                        yAxes: [{
                            type: 'linear', // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
                            display: true,
                            position: 'left',
                            id: 'y-axis-1',
                        }, {
                            type: 'linear', // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
                            display: true,
                            position: 'right',
                            id: 'y-axis-2',
                            // gridLines: {
                            //     drawOnChartArea: false
                            // }
                        }],
                    }
                }
            });

        }

    });


}

function userViseWorksODK() {


    $.ajax({

        method: "post",
        url: "userViseBarChartODK",
        success: function (response) {


            var user = [];
            var count = [];
            var updates = [];
            data = response.trim();
            data = JSON.parse(response);

            for (var i in data) {
                user.push(data[i].user);
                count.push(data[i].count);
                updates.push(data[i].update);
            }

            var chartdata = {
                labels: user,
                datasets: [
                    {
                        label: 'New Works',
                        backgroundColor: 'rgba(54, 162, 235)',
                        borderColor: 'rgba(4, 162, 235)',
                        fill: false,
                        data: count,
                        yAxisID: 'y-axis-1',
                    },
                    {
                        label: 'Updates',
                        backgroundColor: 'rgba(142,68,173)',
                        borderColor: 'rgba(142,68,173)',
                        fill: false,
                        data: updates,
                        yAxisID: 'y-axis-2',
                    },
                ]
            };

            var ctx = document.getElementById("odkacc").getContext('2d');
            var myChart = new Chart(ctx, {
                type: 'line',
                data: chartdata,
                options: {
                    responsive: true,
                    hoverMode: 'index',
                    stacked: false,
                    scales: {
                        yAxes: [{
                            type: 'linear', // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
                            display: true,
                            position: 'left',
                            id: 'y-axis-1',
                        }, {
                            type: 'linear', // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
                            display: true,
                            position: 'right',
                            id: 'y-axis-2',
                            // gridLines: {
                            //     drawOnChartArea: false
                            // }
                        }],
                    }
                }
            });

        }

    });


}

function userViseWorksSL() {


    $.ajax({

        method: "post",
        url: "userViseBarChartSL",
        success: function (response) {

            var user = [];
            var count = [];
            var updates = [];
            data = response.trim();
            data = JSON.parse(response);

            for (var i in data) {
                user.push(data[i].user);
                count.push(data[i].count);
                updates.push(data[i].update);
            }

            var chartdata = {
                labels: user,
                datasets: [
                    {
                        label: 'New Works',
                        backgroundColor: 'rgba(54, 162, 235)',
                        borderColor: 'rgba(4, 162, 235)',
                        fill: false,
                        data: count,
                        yAxisID: 'y-axis-1',
                    },
                    {
                        label: 'Updates',
                        backgroundColor: 'rgba(142,68,173)',
                        borderColor: 'rgba(142,68,173)',
                        fill: false,
                        data: updates,
                        yAxisID: 'y-axis-2',
                    },
                ]
            };

            var ctx = document.getElementById("upwork").getContext('2d');
            var myChart = new Chart(ctx, {
                type: 'line',
                data: chartdata,
                options: {
                    responsive: true,
                    hoverMode: 'index',
                    stacked: false,
                    scales: {
                        yAxes: [{
                            type: 'linear', // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
                            display: true,
                            position: 'left',
                            id: 'y-axis-1',
                        }, {
                            type: 'linear', // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
                            display: true,
                            position: 'right',
                            id: 'y-axis-2',
                            // gridLines: {
                            //     drawOnChartArea: false
                            // }
                        }],
                    }
                }
            });

        }

    });


}
