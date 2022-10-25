<!DOCTYPE html>
<html style="height: 100%">
   <head>
       <meta charset="utf-8">
   </head>
   <body style="height: 100%; margin: 0">
       <div id="container" style="height: 100%"></div>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/echarts.min.js"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts-gl/echarts-gl.min.js"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts-stat/ecStat.min.js"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/extension/dataTool.min.js"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/china.js"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/world.js"></script>
       <script type="text/javascript" src="https://api.map.baidu.com/api?v=2.0&ak=xfhhaTThl11qYVrqLZii6w8qE5ggnhrY&__ec_v__=20190126"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/extension/bmap.min.js"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/simplex.js"></script>
       <script type="text/javascript">
var dom = document.getElementById("container");
var myChart = echarts.init(dom);
var app = {};
option = null;
app.title = '笛卡尔坐标系上的热力图';

var n = ['1', '2', '3', '4', '5', '6', '7'];
   
var k = ['4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14'];

var data = [
[10,0,0.959280452],[10,1,1.509517255],[10,2,2.905517168],[10,3,6.640260927],[10,4,17.59271429],[10,5,49.79190612],[10,6,1529.569055],
[9,0,0.991291398],[9,1,1.591221214],[9,2,3.083591313],[9,3,7.279735939],[9,4,17.25244879],[9,5,83.72070779],
[8,0,1.028595455],[8,1,1.665056351],[8,2,3.313740528],[8,3,7.94170364],[8,4,18.28633827],[8,5,215.8091923],
[7,0,1.067817464],[7,1,1.745030928],[7,2,3.583479523],[7,3,8.446970106],[7,4,22.60029451],
[6,0,1.108495283],[6,1,1.837810387],[6,2,3.873429442],[6,3,8.315819999],[6,4,36.43628786],		
[5,0,1.154170541],[5,1,1.929925424],[5,2,4.158212261],[5,3,8.851039222],		
[4,0,1.19892722],[4,1,2.039535723],[4,2,4.42382916],[4,3,10.13228008],			
[3,0,1.244666974],[3,1,2.182224494],[3,2,4.204779743],				
[2,0,1.293129462],[2,1,2.301125719],[2,2,4.34712681],				
[1,0,1.34912781],[1,1,2.372725345],					
[0,0,1.39798876],[0,1,2.488680356]	
];

    
    
    

data = data.map(function (item) {
    return [item[1], item[0], item[2] || '-'];
});

option = {
    tooltip: {
        position: 'top'
    },
    animation: false,
    grid: {
        height: '50%',
        y: '10%'
    },
    xAxis: {
        position:'top',
        type: 'category',
        data: n,
        name: 'n',
        nameGap:30,
        nameLocation: 'middle',
        splitArea: {
            show: true
        }
    },
    yAxis: {
        type: 'category',
        data: k,
        name: 'k',
        nameGap:30,
        nameRotate:0,
        nameLocation: 'middle',
        splitArea: {
            show: true
        }
    },
    visualMap: {
        min: 0,
        max: 10,
        calculable: true,
        orient: 'horizontal',
        left: 'center',
        bottom: '15%',

    },
    series: [{
        name: 'Punch Card',
        type: 'heatmap',
        data: data,
        label: {
            normal: {
                show: false
            }
        },
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }]
};;
if (option && typeof option === "object") {
    myChart.setOption(option, true);
}
       </script>
   </body>
</html>