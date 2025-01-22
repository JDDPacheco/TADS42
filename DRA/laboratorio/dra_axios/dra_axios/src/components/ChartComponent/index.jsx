import React from 'react';
import { Bar } from 'react-chartjs-2';


const ChartComponent = ({ chartData, chartOptions }) => {
  if (!chartData || !chartOptions) {
    return <p>Dados ou configurações do gráfico estão ausentes!</p>;
  }

  return <Bar data={chartData} options={chartOptions} />;
};

export default ChartComponent;
