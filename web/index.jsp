<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/header.jsp" />



    <div class="row clearfix">
        <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
            <div class="info-box bg-pink hover-expand-effect">
                <div class="icon">
                    <i class="material-icons">playlist_add_check</i>
                </div>
                <div class="content">
                    <div class="text">FIVERR [GSANDARU]</div>
                    <div class="number count-to" id="gsandaru">125</div>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
            <div class="info-box bg-cyan hover-expand-effect">
                <div class="icon">
                    <i class="material-icons">help</i>
                </div>
                <div class="content">
                    <div class="text">FIVERR [DILL]</div>
                    <div class="number count-to" id="dill">257</div>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
            <div class="info-box bg-light-green hover-expand-effect">
                <div class="icon">
                    <i class="material-icons">forum</i>
                </div>
                <div class="content">
                    <div class="text">FIVERR [ODK]</div>
                    <div class="number count-to" id="odk">243</div>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
            <div class="info-box bg-orange hover-expand-effect">
                <div class="icon">
                    <i class="material-icons">person_add</i>
                </div>
                <div class="content">
                    <div class="text">UPWORKS & SL</div>
                    <div class="number count-to" id="upworks">1225</div>
                </div>
            </div>
        </div>
    </div>

<div class="row clearfix">

    <div class="col-md-6">

        <div class="block-header">
            <h2>ACCOUNT VISE WORKS</h2>
        </div>

        <canvas id="accountvise" height="250px"></canvas>

    </div>

    <div class="col-md-6">

        <div class="block-header">
            <h2>USER VISE WORKS</h2>
        </div>

        <canvas id="uservise" height="250px"></canvas>

    </div>

</div>

<div class="row clearfix">

    <div class="col-md-6" style="margin-top: 20px">
        <div class="block-header">
            <h2>SANDARU</h2>
        </div>

        <canvas id="sandaruacc" height="250px"></canvas>
    </div>
    <div class="col-md-6" style="margin-top: 20px">
        <div class="block-header">
            <h2>DILL</h2>
        </div>

        <canvas id="dillacc" height="250px"></canvas>
    </div>
    <div class="col-md-6" style="margin-top: 20px">
        <div class="block-header">
            <h2>ODK</h2>
        </div>

        <canvas id="odkacc" height="250px"></canvas>
    </div>
    <div class="col-md-6" style="margin-top: 20px">
        <div class="block-header">
            <h2>UPWORK & SL</h2>
        </div>

        <canvas id="upwork" height="250px"></canvas>
    </div>

</div>



<jsp:include page="/footer.jsp" />
<script src="${pageContext.request.contextPath}/js/customescripts/charts.js"></script>