<%--
User: Kristian
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.4.0/fullcalendar.min.js"></script>
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.4.0/fullcalendar.min.css"></link>

    <title>Calendar</title>
    <script>
       $(document).ready(function() {
        // page is now ready, initialize the calendar...
            $.ajax({
                url: 'calendar',
                dataType: "json",
                success: function(response) {
                    $('#calendar').fullCalendar({
                        locale: 'da',
                        header: {
                            left: 'prev,next today',
                            center: 'title',
                            right: 'month'
                        },

                        editable: true,
                        slotMinutes: 10,
                        firstHour: 8,
                        minTime: 8,
                        maxTime: 22,
                        // use "[response]" if only one event
                        events: response
                    });
                }
            });
    });

    </script>
  </head>
  <body>

  <%@include file="includes/header.jsp" %>
  <div id="wrapper">
  </div>
  <div id='calendar'></div>
  <%@include file="includes/footer.jsp" %>
  </body>
</html>
