		<?php


		if(isset($_REQUEST["filterType"])){
			$filterType = $_REQUEST["filterType"];
			if($filterType == 'email'){
				$filterCriteria =  "u.email='".$_REQUEST["filterValue"]."'"; 
			}else if($filterType == 'mobile'){
				$filterCriteria =  "u.mobile='".$_REQUEST["filterValue"]."'"; 
			}else{
				$filterCriteria =  "u.caseId=".$_REQUEST["filterValue"]; 
			}
		}			
		$db = mysql_connect("127.0.0.1", 'root', 'root');
		if(isset($filterCriteria)){
			$sql = "select u.caseId as caseId, u.callerName as callerName, u.details as details, u.email as email,u.mobile as mobile,u.address as address,u.create_date as create_date,p.gender as gender,p.detailsOfInjury as detailsOfInjury,p.pickUpLocation as pickUpLocation from user u inner join pet p on u.caseId=p.caseId and ".$filterCriteria;
			if (!$db) die('Could not connect --'.mysql_error());
		else{
			mysql_select_db('hospital',$db);
			$info=query($sql,$db);
			$dump =  json_encode($info);
			echo $dump;
			
		}
		mysql_close($db);
		}else{
			
		}

		function query($sql,$mysqlConn) {
		$resource = mysql_query($sql, $mysqlConn);

		if ($resource) {
			if (is_resource($resource)) {
				$i = 0;
				$data = array();
				while ($result = mysql_fetch_assoc($resource)) {
					$data[$i] = $result;
					$i++;
				}

				mysql_free_result($resource);

				$query = new stdClass();
				$query->row = isset($data[0]) ? $data[0] : array();
				$query->rows = $data;
				$query->num_rows = $i;

				unset($data);

				return $query;
    		} else {
				return true;
			}
		} else {
			trigger_error('Error: ' . mysql_error($mysqlConn) . '<br />Error No: ' . 
				mysql_errno($mysqlConn) . '<br />' . $sql);
			return false;
    	}
  	}
		?>
