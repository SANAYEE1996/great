var context = document.getElementById('foreignRatio').getContext('2d');
    var myChart = new Chart(context, {
      type: 'pie', // 차트의 형태
      data: { // 차트에 들어갈 데이터
          labels: [
              //x 축
              '한국인','외국인'
          ],
          datasets: [
              { //데이터
                  label: 'test1', //차트 제목
                  fill: false, // line 형태일 때, 선 안쪽을 채우는지 안채우는지
                  data: [
                      korean,foreign //x축 label에 대응되는 데이터 값
                  ],
                  backgroundColor: [
                      //색상
                      'rgba(255, 99, 132, 0.2)',
                      'rgba(54, 162, 235, 0.2)'/*,
                      'rgba(255, 206, 86, 0.2)',
                      'rgba(75, 192, 192, 0.2)',
                      'rgba(153, 102, 255, 0.2)',
                      'rgba(255, 159, 64, 0.2)'*/
                  ],
                  borderColor: [
                      //경계선 색상
                      'rgba(255, 99, 132, 1)',
                      'rgba(54, 162, 235, 1)'/*,
                      'rgba(255, 206, 86, 1)',
                      'rgba(75, 192, 192, 1)',
                      'rgba(153, 102, 255, 1)',
                      'rgba(255, 159, 64, 1)'*/
                  ],
                  borderWidth: 1 //경계선 굵기
              }
          ]
    }
 });

var context1 = document.getElementById('likeRatio').getContext('2d');
    var myChart = new Chart(context1, {
      type: 'bar', // 차트의 형태
      data: { // 차트에 들어갈 데이터
          labels: [
              //x 축
              '싫어요','좋아요'
          ],
          datasets: [
              { //데이터
                  label: '좋아요 싫어요', //차트 제목
                  fill: false, // line 형태일 때, 선 안쪽을 채우는지 안채우는지
                  data: [
                      dislike,like //x축 label에 대응되는 데이터 값
                  ],
                  backgroundColor: [
                      //색상
                      'rgba(255, 99, 132, 0.2)',
                      'rgba(54, 162, 235, 0.2)'/*,
                      'rgba(255, 206, 86, 0.2)',
                      'rgba(75, 192, 192, 0.2)',
                      'rgba(153, 102, 255, 0.2)',
                      'rgba(255, 159, 64, 0.2)'*/
                  ],
                  borderColor: [
                      //경계선 색상
                      'rgba(255, 99, 132, 1)',
                      'rgba(54, 162, 235, 1)'/*,
                      'rgba(255, 206, 86, 1)',
                      'rgba(75, 192, 192, 1)',
                      'rgba(153, 102, 255, 1)',
                      'rgba(255, 159, 64, 1)'*/
                  ],
                  borderWidth: 1 //경계선 굵기
              }
          ]
    }
});