alert("hai");
function raiseInvoice()
			{
				alert("hai");
				var barVal = document.forms[0].barbie.value;
				var calVal = document.forms[0].calc.value;
				var mobphVal = document.forms[0].mobph.value;
				var lgdvdVal = document.forms[0].lgdvd.value;
				var display = "<table>";
				display = "<tr><th> PRODUCT </th><th> QUANTITY </th><th> PRICE </th><th> TOTAL </th></tr>";
				if(barVal>0)
				{
					var barTot = barVal*20;
					display="<td>Barbie Doll</td><td>"+barVal+"</td><td>20</td><td>"+barTot+"</td>";
				}
				if(calVal>0)
				{
					var calTot = calVal*30;
					display="<td>Calculator</td><td>"+calVal+"</td><td>30</td><td>"+calTot+"</td>";
				}
				if(mobphVal>0)
				{
					var mobphTot = mobphVal*40;
					display="<td>Mobile Phones</td><td>"+mobphVal+"</td><td>40</td><td>"+mobphTot+"</td>";
				}
				if(lgdvdVal>0)
				{
					var lgdvdTot = lgdvdVal*50;
					display="<td>LG DVD</td><td>"+lgdvdVal+"</td><td>50</td><td>"+lgdvdTot+"</td>";
				}
				display = "</table>";
				if(barVal>0 || calVal >0 || mobphVal>0 || lgdvdVal>0)
				{
						var preWin = open("","Invoice""height=400,widht=600,left=200,top=500");
						var preDoc = preWin.document;			
						preDoc.write(display);
				}
			}